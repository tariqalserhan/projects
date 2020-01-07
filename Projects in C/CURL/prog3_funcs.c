#include <stdio.h>       /* for fprintf and getline */
#include <string.h>      /* for strlen */
#include <stdlib.h>      /* for free */
#include <errno.h>       /* for errno, strerror */
#include <curl/curl.h>   /* for curl, baby! */
#include <sys/stat.h>    /* For chmod */
#include "prog3_funcs.h"
#define BLOCKSIZE 16

#ifdef DEBUG
#define DEBUG 1
#else
#define DEBUG 0
#endif
  void  parseArgs(int argc, char *argv[], char **ifile, char **ofile, char **kfile, char **server, char **directory, char **userid, char **password) {//ParseArguments requires number of arguments and arguments entered

/*create flags to help with error messages*/

  int iflag = 0;
  int oflag = 0;
  int kflag = 0;
  int sflag = 0;
  int dflag = 0;
  int uflag = 0;
  int pflag = 0;

  int i = 1;
   if (argc == 1) help();

    for (i; i < argc; i++) {
      if (!strcasecmp(argv[i], "-h") || !strcasecmp (argv[i], "--help")) {
        help();
    }
      else if (!strcasecmp(argv[i], "-i") || !strcasecmp (argv[i], "--input")) {
        iflag = 1;
        if (++i < argc) {
       *ifile = argv[i];
      } else {
        bail(3, "No argument after '-i|--input'");
      }
   } else if (!strcasecmp(argv[i], "-o") || !strcasecmp (argv[i], "--output")) {
      oflag = 1;
      if (++i < argc) {
       *ofile = argv[i];
      } else {
        bail(4, "No argument after '-o|--output'");
      }
 } else if (!strcasecmp(argv[i], "-k") || !strcasecmp (argv[i], "--key")) {
      kflag = 1;
      if (++i < argc) {
       *kfile = argv [i];
      } else {
        bail(5, "No argument after '-k|--key'");
      }
    }
else if (!strcasecmp(argv[i], "-s") || !strcasecmp (argv[i], "--server")) {
      sflag = 1;
      if (++i < argc) {
      *server = argv [i];
      } else {
        bail(6, "No argument after '-s|--server'");
      }
    }else if (!strcasecmp(argv[i], "-d") || !strcasecmp (argv[i], "--directory")) {
      dflag = 1;
      if (++i < argc) {
      *directory= argv [i];
      } else {
        bail(7, "No argument after '-d|--directory'");
      }
    }else if (!strcasecmp(argv[i], "-u") || !strcasecmp (argv[i], "--userid")) {
      uflag = 1;
      if (++i < argc) {
      *userid = argv [i];
      } else {
        bail(8, "No argument after '-u|--userid'");
      }
    } else if (!strcasecmp(argv[i], "-p") || !strcasecmp (argv[i], "--password")) {
      pflag = 1;
      if (++i < argc) {
      *password = argv [i];
      } else {
        bail(9, "No argument after '-p|--password'");
      }
    } else {
      bail(1, "Incorrect/unexpected argument entered, run without any arguments or with '-h|--help' for help");
}
    } // end of for loop
if (iflag * oflag * kflag * pflag * uflag * sflag * dflag == 0){
    bail(2, "One or more arguments not specified");
    }
}

void *Malloc(size_t size) {
  char str[128];
  void *ptr;
  if ((ptr = malloc(size)) == NULL) {
    sprintf(str, "Could not allocate space - %s", strerror(errno));
    bail(99, str);
  }
  return ptr;
}
FILE *Fopen(const char *path, const char *mode) {//opens the file with the mode 
  FILE *fp = NULL;
  char str[128];
  if ((fp = fopen(path, mode)) == NULL) {
    sprintf(str, "Unable to open %s with mode %s - %s", path, mode, strerror(errno));
    bail(10, str);
  }
  return fp;
}

void readKey(unsigned char *key, size_t block_size, FILE *fp) {//reads key for decryption
  size_t items_read = 0;
  char str[128];          /* for error msg */
  if ((items_read = Fread(key, sizeof(char), block_size, fp)) < block_size) {
    sprintf(str, "Key is fewer bytes than expected (%zu vs. %zu)", items_read, block_size);
    bail(20, str);
  }
}
size_t Fread(void *ptr, size_t item_size, size_t num_items, FILE *fp) { //reads the file fp and returns items read
    size_t itemsRead = fread(ptr, item_size, num_items, fp);
    return itemsRead;
}

void encryptDecrypt(unsigned char *block, unsigned char *key, size_t block_size, FILE *fip, FILE *fop) {
  size_t items_read;
  size_t items_written;
  size_t i = 0;
  while (!feof(fip)) {
    items_written = 0;
    if ((items_read = Fread(block, sizeof(char), block_size, fip))) {
for ( i; i < items_read; i++) {
       if (DEBUG) printf("%#04X ^ %#04X = ", block[i], key[i]);
        block[i] ^= key[i];
        if (DEBUG) printf("%#04X\n", block[i]);
      }
      items_written = Fwrite(block, sizeof(char), items_read, fop);
    }
    if (items_written != items_read)
      bail(30, "Unable to write all items read");
i = 0;
}
}

size_t Fwrite(const void *ptr, size_t item_size, size_t num_items, FILE *fp) {//writes the file
  size_t items_written = 0;
  char str[128];

  if ((items_written = fwrite(ptr, item_size, num_items, fp)) == 0) {
    if (ferror(fp)) {
      sprintf(str, "Encountered error while writing to file descriptor %d - %s", fileno(fp), strerror(errno));
      bail(12, str);
    }
  }
  return items_written;
}
void Fclose(FILE *fp) {//closes the file
  char str[128];
  if (fp && fclose(fp)) {
    sprintf(str, "Unable to close file descriptor %d - %s", fileno(fp), strerror(errno));
    bail(13, str);
  }
}

void bail(int err, const char * message) { /* in: rc to exit with, ptr to message to print */
      fprintf(stderr, "(%d) %s\n", err, message);
      exit(err);
    }

void help() { //Prints out the help message    
    fprintf(stdout,"prog3 -i|--input <calculation file> -o|--output <results file> -k|--key <key file> -s|--server <server_name> -d|--directory <directory_on_server> -u|--userid <userID> -p|--password <password>\n");
    fprintf(stdout, "or\n");
    fprintf(stdout, "prog3 [-h|--help]\n");
    exit(0);
    }
/*THE CURL METHODS*/

int ftpDownload(char *userid, char *password, char *server, char *pathname) {
  char str[128];                                               /* character string for setting curl settings, call values, or bail messages */
  CURLcode crc;                                                /* variable to hold CURL function recturn codes */
  CURL *cp = NULL;                                             /* pointer/handle to curl session/transfer */
  ftpFile_t FTPfile = { "taa221.enc", NULL };                  /* declare and define an ftpFile_t object, you can change filename or make it a variable */

  curl_global_init(CURL_GLOBAL_ALL);                           /* initializes curl global state; setup and initializes underlying libraries */

  cp = curl_easy_init();                                       /* initialize pointer/handle for curl session/transfer */

  if (cp) {                                                    /* check if curl handle creation was successful, and if so, proceed */
    sprintf(str, "%s:%s", userid, password);
    curl_easy_setopt(cp,CURLOPT_USERPWD, str);                 /* set username and password */
    sprintf(str, "sftp://%s/%s", server, pathname);
    curl_easy_setopt(cp,CURLOPT_URL, str);                     /* set protocol, server, directory, and file */

    curl_easy_setopt(cp, CURLOPT_WRITEFUNCTION, ftpWrite);     /* declare the function we want called after the connection succeeds */

    curl_easy_setopt(cp, CURLOPT_WRITEDATA, &FTPfile);         /* set a pointer to our struct to pass to the callback */

    curl_easy_setopt(cp, CURLOPT_VERBOSE, 1L);                 /* switch on full protocol/debug output */

    crc =  curl_easy_perform(cp);                              /* perform the curl call and capture the return code*/

    curl_easy_cleanup(cp);                                     /* cleanup local session/transfer */


  } else {                                                     /* bail in the unlikely event curl handle creation failed */
    bail(99, "Initialization of curl session/transfer handle was unsuccessful");
  }

    Fclose(FTPfile.stream);                                    /* close the local file */

    curl_global_cleanup();                                      /* free and clean up associated global resources init call allocated */

    return (int)crc;                                            /* return curl return code */
}
size_t ftpWrite(void *buffer, size_t size, size_t nmemb, void *stream) {
  ftpFile_t *oFile = (ftpFile_t *)stream;
  if(!oFile->stream)
    oFile->stream = Fopen(oFile->filename, "w");  /* open file for writing */
  return Fwrite(buffer, size, nmemb, oFile->stream);
}

 size_t ftpRead(void * buffer, size_t size, size_t nmemb, void * stream) {
     ftpFile_t * oFile = (ftpFile_t * ) stream;
     if (!oFile -> stream)
         oFile -> stream = Fopen(oFile -> filename, "w"); /* open file for writing */
     return Fread(buffer, size, nmemb, oFile -> stream);
 }
int ftpUpload(char * userID, char * password, char * server, char * pathname,char *output,FILE * finalFile) {
     char str[128];                                              /* character string for setting curl settings, call values, or bail messages */
     CURLcode crc;                                               /* variable to hold CURL function recturn codes */
     CURL * cp = NULL;                                           /* pointer/handle to curl session/transfer */
     ftpFile_t FTPfile = { output, finalFile};                   /* declare and define an ftpFile_t object, you can change filename or make it a variable */

     curl_global_init(CURL_GLOBAL_ALL);                          /* initializes curl global state; setup and initializes underlying libraries */

     cp = curl_easy_init();                                      /* initialize pointer/handle for curl session/transfer */

     if (cp) {

         sprintf(str, "%s:%s", userID, password);                /* set username and password */
         curl_easy_setopt(cp, CURLOPT_USERPWD, str);

         sprintf(str, "sftp://%s/%s", server, pathname);         /* set protocol, server, directory, and file */
         curl_easy_setopt(cp, CURLOPT_URL, str);

         curl_easy_setopt(cp, CURLOPT_UPLOAD, 1L);               /* enable uploading */

         curl_easy_setopt(cp, CURLOPT_READFUNCTION, ftpRead);    /* declare the function we want called after the connection succeeds */
         curl_easy_setopt(cp, CURLOPT_READDATA, & FTPfile);      /* specify the file we want to upload */

         curl_easy_setopt(cp, CURLOPT_VERBOSE, 1L);              /* switch on full protocol/debug output */

         crc = curl_easy_perform(cp);                            /* perform the curl call and capture the return code*/

         curl_easy_cleanup(cp);                                  /* cleanup local session/transfer */

         } else {                                                /* bail in the unlikely event curl handle creation failed */
         bail(99, "Initialization of curl session/transfer handle was unsuccessful");
        }

        curl_global_cleanup();

     return (int) crc; /* return curl return code */
 }
