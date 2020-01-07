/*
 * Course: CSE109
 * Semester and Year: Fall 2019
 * Assignment: cURL
 * File Purpose: download an encrypted file using curl, decrypt the file with a mathematical equation, solve it, encrypt the file and upload 
 * Author: Al-Serhan, Tariq
 * User ID: taa221
 */


void  parseArgs(int, char *[], char **, char **, char **, char **, char **, char **, char **);
void * Malloc(size_t );
FILE * Fopen(const char *, const char * );
void readKey(unsigned char *, size_t , FILE *);
size_t Fread(void * , size_t , size_t , FILE *);
void encryptDecrypt(unsigned char *, unsigned char *, size_t , FILE *, FILE *);
size_t Fwrite(const void * , size_t , size_t , FILE *);
void Fclose(FILE *);
void bail(int, const char * );
void help(void);
int ftpDownload(char * , char * , char * , char * );
size_t ftpWrite(void * , size_t, size_t, void * );
size_t ftpRead(void * , size_t, size_t, void * );
int ftpUpload(char * , char * , char *, char*, char*, FILE * );

struct ftpfile {
    const char * filename; /* name to store the file as */
    FILE * stream; /* file pointer */
};
typedef struct ftpfile ftpFile_t;