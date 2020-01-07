/*
 * Course: CSE109
 * Semester and Year: Fall 2019
 * Assignment: cURL
 * File Purpose: download an encrypted file using curl, decrypt the file with a mathematical equation, solve it, encrypt the file and upload 
 * Author: Al-Serhan, Tariq
 * User ID: taa221
 */

#include <stdio.h>       /* for fprintf and getline */
#include <string.h>      /* for strlen */
#include <stdlib.h>      /* for free */
#include <errno.h>       /* for errno, strerror */
#include <curl/curl.h>   /* for curl, baby! */
#include <sys/stat.h> /* For chmod */
#include "prog3_funcs.h"
#define BLOCKSIZE 16
int main(int argc, char * argv[]) {
  char * ifile = NULL; /* to point to input file name */
  FILE * fip = NULL; /* to point to opened input file */
  char * ofile = NULL; /* to point to output file name */
  FILE * fop = NULL; /* to point to opened output file */
  char * kfile = NULL; /* to point to key file name */
  FILE * fkp = NULL; /* to point to opened key file */
  FILE * tmp = NULL; /* we need this for the encrypted file */
  char * server = NULL;
  char * directory = NULL;
  char * userid = NULL;
  char * password = NULL;
  char str[256]; /*for curl*/
  int rc = 0; /*for curl*/
  unsigned char block[BLOCKSIZE]; /* to hold bytes read from input file */
  unsigned char key[BLOCKSIZE]; /* to hold key for encryption/decryption read from key file */

  parseArgs(argc, argv, & ifile, & ofile, & kfile, & server, & directory, & userid, & password); /* parse arguments and return pointers to filenames */

  char * pathDownload = (char * ) Malloc(strlen(directory) + strlen(ifile) + 1); /*create a path name for the downloadedfile using the directory and the input filename */
  strcpy(pathDownload, directory);
  strcat(pathDownload, ifile);


  rc = ftpDownload(userid, password, server, pathDownload); /* call ftpDownload function and capture return code */
  if (rc) {
    /* bail if transfer was unsuccessful */
    sprintf(str, "Unable to download %s from %s (curl rc = %d (%s))", userid, server, rc, curl_easy_strerror(rc));
    bail(15, str);
  }

  fip = Fopen(ifile, "r");/*open the ifile in read mode*/
  fop = Fopen(ofile, "w");/*open the ofile in write mode*/
  fkp = Fopen(kfile, "r");/*open the kfile in read mode */
  
  readKey(key, BLOCKSIZE, fkp); /* read the key for encryption/decryption */
  encryptDecrypt(block, key, BLOCKSIZE, fip, fop); /* encrypt/decrypt the input file and write to output file */

  Fclose(fip);/*close the files after decryption*/
  Fclose(fop);
  Fclose(fkp);

/*THE MATHEMATICAL OPERATION*/

  fop = Fopen(ofile, "r+"); //open the output file
  rewind(fop);

  char op;
  int var1;
  int var2;
  int result;
  char * line = NULL;
  size_t len = 1000;
  getline( & line, & len, fop); //use getline to get the line from file 
  sscanf(line, "%d %c %d", & var1, & op, & var2); //use sscanf to get each integer and the operator 

  if(op == '+') result = var1 + var2; //check what operation 
  else if (op == '-') result = var1 - var2;
  else if (op == '*') result = var1 * var2;

  Fclose(fop);

  fop = Fopen(ofile, "w+"); //write the mathematical equation in the output file  
  rewind(fop);
  fprintf(fop, "%d %c %d = %d\n", var1, op, var2, result);
  Fclose(fop);
/*END OF MATHEMATICAL OPERATION*/
  tmp = Fopen("EncryptedResult_taa221.txt", "w"); //create a file that would hold the encrypted result
  fop = Fopen(ofile, "r");
  fkp = Fopen(kfile, "r");
  rewind(fkp);
  rewind(fop);

/*THE ENCRYPTION*/
  readKey(key, BLOCKSIZE, fkp);
  encryptDecrypt(block, key, BLOCKSIZE, fop, tmp); //perform the encryption

  Fclose(fkp);
  Fclose(fop);
  Fclose(tmp);

/*THE UPLOAD*/
  char *pathUp  =(char*) Malloc(strlen(directory)+strlen(ofile)+1);
  strcpy(pathUp,directory);
  strcat(pathUp,ofile);
  tmp = Fopen("EncryptedResult_taa221.txt", "r+"); //create a file that would hold the encrypted result
  rewind(tmp);
  rc = ftpUpload(userid, password, server,pathUp,ofile,tmp);
  if (rc) {                                                  /* bail if transfer was unsuccessful */
        sprintf(str, "Unable to Upload %s to %s (curl rc = %d (%s))", ofile,server, rc, curl_easy_strerror(rc));
        bail(16, str);
}

 Fclose(tmp);
/*FREE UP MALLOCATED SPACES*/
 free(pathDownload);
 free(pathUp);
 free(line);
 return 0;
}
