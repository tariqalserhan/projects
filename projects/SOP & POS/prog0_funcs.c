//Tariq Al-Serhan 
//Sep 14 2019 

#include <stdlib.h>
#include <stdio.h>

char parseArgs(int argc, char * argv[]) { //ParseArguments requires number of arguments and arguments entered 
  if (argc == 2) { //argc takes prog0 as an argument and the other argument is either pos or sop or -h 
    char pos[100] = "pos";
    char sop[100] = "sop";
    char h[100] = "-h";

    if (strcasecmp(argv[1], pos) == 0) { //Case insensitive comparison to find out the argument passed  
      return 1; //Return "1" for pos "0" for sop and go to help function for "-h"
    } else if (strcasecmp(argv[1], sop) == 0) {
      return 0;
    } else if (strcasecmp(argv[1], h) == 0) {
      help();
    } else { //if argument enetered is not "sop", "pos", or "-h"   
      bail(2, "Enter a single argument of either 'sop', 'pos', or '-h' (for help)\n");
    }
  } else { //If number of arguments is more or less than two  
    bail(1, "Enter a single argument of either 'sop', 'pos', or '-h' (for help)\n");
  }
}
void collectInput(char ** name, int * faveNum) {

  char * line = NULL; //Create a character point to hold line
  size_t length = 0;

do{
    printf("\nPlease input your first and last name (Cntl+D to exit):");
    getline(&line, &length, stdin);//Scan for input using getline
  } while (!*line || line [0] == '\n');
  * name = line; //derefrence name to 

  printf("Please input your favorite integer value (Cntl+D to exit):"); //Prompt the user for integer 
  while(scanf("%d", faveNum)!= 1){
  printf("Please input your favorite integer value (Cntl+D to exit):");
  scanf("%d",faveNum);
  }
  //Scan for integer 
}
size_t calcValue(char op, char ** name, int faveNum, long * result) {
  long value = 0; //Create a variable to hold the result 
  size_t flag = 0; //Create a flag variable to check for overflow and underflow
  int i;

  if (op == 0) { //If argument is sop to calculate sum of products 
    for (i = 0; i < strlen( * name); i++) { //Iterate through the name for each character 
      char c = ( * name)[i];
      if ((96 < c && c < 123) || (64 < c && c < 91) || c == 45) {
        value += (c * faveNum);
        if (value > 2147483647  || value < -2147483648) { //check for the exact number 
          flag = 1; //Flag goes to 1 if overflow or underflow
        }
      }
    }

    * result = value; //save value to result
  } else if (op == 1) { //pos profuct of sums 
    value = 1;  // set value to 1 for multiplication purposes 

    for (i = 0; i < strlen( * name); i++) {
      char c = (* name)[i];
      if ((96 < c && c < 123) || (64 < c && c < 91) || c == 45) {
        value *= (c + faveNum);
        if (value > 2147483647  || value < -2147483648)  { // check for overflow and underflow
          flag = 1;
        }
      }
    }
    * result = value; //Set value to result 

  }
  return flag;

}
void printResult(char op, long result, size_t unrep) { //print the results based on the argument 
  if (op == 1) {
    fprintf(stdout, "%s\n%ld\n", "pos", result);
  }
  if (op == 0) {
    fprintf(stdout, "%s\n%ld\n", "sop", result);
  }
  if (unrep == 1) {
    bail(3, "Underflow or OverFlow Occurred");
  }
}

void bail(int err,
  const char * message) {
  /* return code and message to print */
  fprintf(stderr, "(%d) %s\n", err, message);
  exit(err);
}
void help() { //help message 
  fprintf(stdout, "\n");
  fprintf(stdout, "prog0 prompts the user for their first and last name and their favorite integer and\n");
  fprintf(stdout, "calculates the sum-of-products or product-of-sums based on the integer entered and\n");
  fprintf(stdout, "the ASCII value of each character in the first and last name entered. Note that \n");
  fprintf(stdout, "non-alphabetical characters, except for hyphen and apostrophe, are ignored.\n");
}