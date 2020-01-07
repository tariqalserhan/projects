#define BLOCKSIZE 16 
#ifndef PROG0_FUNCS
#define PROG0_FUNCS
#include <stdio.h>       /* for fprintf, sprintf */
#include <stdio.h>       /* for fprintf, sprintf */
#include <stdlib.h>      /* for exit */
#include <errno.h>       /* error handling */
#include <string.h>      /* for ? */
#include "prog1_funcs.h"
/* if we compile with gcc -DDEBUG, we will set the DEBUG macro to 1 */
#ifdef DEBUG
#define DEBUG 1
#else
#define DEBUG 0
#endif

void parseArgs(int argc, char *argv[], char **ifile, char **ofile, char **kfile) { /* in: argc, argv; out: ifile, ofile, kfile */
  char h1[100] = "-h";
  char h2[100] = "--help";
  char i1[100] = "-i";
  char i2[100] = "--input";
  char o1[100] = "-o";
  char o2[100] = "--output";
  char k1[100] = "-k";
  char k2[100] = "--key";
  //create flags for ifile , ofile, and kfile 
  int iflag = 0;
  int oflag = 0;
  int kflag = 0;
  int i = 1;
  if (argc == 2) { //if we have only two arguments where arg[1] is for help  
    if ((strcasecmp(argv[1], h1) == 0) || (strcasecmp(argv[1], h2) == 0)) {
      help();
    }
  }

  else{
  for( i; i < argc; i =  i+2){ // create a for loop to access all the executables(-i , -o, -k), that's why we jump by two and check for the errors as specified 
    if ((strcasecmp(argv[i], i1) == 0) || (strcasecmp(argv[i], i2) == 0)) {
      iflag = 1; //set flag to 1e
      if (argc - i  == 1) {// This checks if there is nothing after the current argument 
        bail(3, "No argument after 'i|--input'");
        } else { // if it is not the last executable malloc the next argument to file 

        *ifile = Malloc(sizeof(argv[i + 1] + 1));
        strcpy(*ifile, argv[i + 1]);
      }
    }

    else if ((strcasecmp(argv[i], o1) == 0) || (strcasecmp(argv[i], o2) == 0)) {
      oflag = 1;//set flag to 1 
      if (argc - i == 1) { // check if this argument is the last argument entered 
        bail(4, "No argument after 'o|--output'");
      } else {
        *ofile = Malloc(sizeof(argv[i + 1] + 1));
        strcpy(*ofile, argv[i + 1]);
      }
    }
    else if ((strcasecmp(argv[i], k1) == 0) || (strcasecmp(argv[i], k2) == 0)) {
      kflag = 1;//set flag to 1 
      if (argc - i == 1) {
        bail(5, "No argument after 'k|--keyfile'");
      } else {
        *kfile = Malloc(sizeof(argv[i + 1] + 1));
        strcpy( *kfile, argv[i + 1]);
      }
    }

    else {
      bail(1, "Incorrect/unexpected argument entered");
    }
  }

  if (iflag == 0 || oflag == 0 || kflag == 0) { //if one or more of the flags is not activated we bail with this message 
    bail(2, "One or more arguments not specified");
 }
 }
}

void *Malloc(size_t numBytes) { /* in: bytes to allocated; return: void ptr to allocated memory */
  void *ptr = NULL;
  if ((ptr = malloc(numBytes)) == NULL) {
    fprintf(stderr, "Could not allocate space - %s", strerror(errno)); //print to errno
    bail(99, "Could not allocate space *"); /* no changes */
  }
  return ptr;
}

FILE *Fopen(const char *filename,const char *mode) {  /* in: path/file, mode; return: file ptr */
  FILE *fp; // create file fp 
  fp = fopen(filename, mode); //open the file
  if (fp == NULL) {
    fprintf(stderr, "Unable to close file - %s", strerror(errno));//print error to errno 
    bail(10, "Unable to open file ");
  } else if (filename != NULL) {//if there is a file we open and we  have to free memory of file name 
    free ((void*)filename);
  }
  return fp;
}
void readKey(unsigned char *ptr, size_t length, FILE *stream) { /* in: buffer ptr, key length, key file ptr */
        size_t size = Fread(ptr, sizeof(char), length, stream);
        if (size < length) { // if the key size is fewer bytes than the length 
        bail(20, "Key is fewer bytes than expected");
      }
    }
void encryptDecrypt(unsigned char * block, unsigned char * key, size_t blocksize, FILE * fip, FILE * fop) { /* in: buffer ptr, key ptr, buffer size, input file ptr, output file ptr */

      char out[blocksize];  //create character array to hold blocksize to 16 
      size_t fread; //create variable for fread 
      size_t fwrite; // create variable for fwrite 
      size_t i = 0;
      fread = Fread(block, sizeof(char), blocksize, fip);
      while (fread) { // if fread is not 0 
        for (i ; i < fread; i++) {
          out[i] = block[i] ^ key[i];
          if (DEBUG)
            fprintf(stdout, "0X%02X ^ 0X%02X = 0X%02X\n", block[i], key[i], out[i]);
        }
        Fwrite(out, sizeof(char), fread, fop);
        fread = Fread(block, sizeof(char), fread, fip);
        i = 0; //reset counter to 0 to read 16 bytes again 
        fwrite = Fwrite(block, sizeof(char), fread, fop);
      }
      if(fwrite != fread){//check if the written bytes to fop are equal to the ones read in fip 
      bail(30,"Unable to write all items read");
    }
    }

    size_t Fread(void *ptr, size_t size, size_t nitems, FILE *stream) { /* in: buffer ptr, buffer size, num buffers, input file ptr; return: bytes read */
      size_t numread =  fread(ptr, size, nitems, stream);
      if(numread > nitems){ // if fread returns number more than the actual items then there is an error reading the file ey is fewer bytes than expected
      fprintf(stderr, "Error reading file - %s", strerror(errno));
      bail(11, "Error reading file");
    }
    return numread;
    }

    size_t Fwrite(const void *ptr, size_t size, size_t nitems, FILE *stream) {  /* in: buffer ptr, buffer size, num buffers, output file ptr; return: bytes written */
       size_t numwrite = fwrite(ptr, size, nitems, stream);
       if(numwrite != nitems){
       fprintf(stderr, "Error writing file - %s", strerror(errno));
       bail(12, "Error writing file");
       }
       return numwrite;

    }
  size_t Fwrite(const void *ptr, size_t size, size_t nitems, FILE *stream) {  /* in: buffer ptr, buffer size, num buffers, output file ptr; return: bytes written */
       size_t numwrite = fwrite(ptr, size, nitems, stream);
       if(numwrite != nitems){
       fprintf(stderr, "Error writing file - %s", strerror(errno));
       bail(12, "Error writing file");
       }
       return numwrite;

    }
    void Fclose(FILE *stream) {// closes file if file able to close if not error /* in: file ptr */ 
      int flag = fclose(stream);
      if (flag != 0) {
        fprintf(stderr, "Unable to close file - %s", strerror(errno));
        bail(13, "Unable to close file");
      }
    }
    void bail(int err,const char * message) {
      /* in: rc to exit with, ptr to message to print */
      fprintf(stderr, "(%d) %s\n", err, message);
      exit(err);
    }
    void help() {
      fprintf(stdout, "\n");
      fprintf(stdout, "\nprog1 performs an XOR-based encryption/decryption on the specified input file using the\n");
      fprintf(stdout, "specified key file to produce the specified output file.\n");
      fprintf(stdout, "\n");
      fprintf(stdout, "prog1 -i|--input <input file> -o|--output <output file> -k|--key <key file>\n");
      fprintf(stdout, "or\n");
      fprintf(stdout, "prog1 [-h|--help]\n");
      exit(0);
     }
#endif
