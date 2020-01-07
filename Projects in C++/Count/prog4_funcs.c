/*
 * Course: CSE109
 * Semester and Year: Fall 2019
 * Assignment: Count
 * File Purpose: Counts the occurances of each character from STDIN
 * Author: Al-Serhan, Tariq
 * User ID: 814839379
 */

#include "Count.h"
#include "prog4_funcs.h"
#include <iostream>
#include <ios>
#include <string.h>
#include <string>


void parseFile(Count *object){
    std :: string input;  //this is the current line we are reading from stdin     
    std :: string total;    //the total input (which is a sum of each "current line" until the end of input)


    while(std::getline(std::cin ,input)){ //reads inputted line from STDIN or the text file using getline
            total = total + input + "\n";
        }

    for(unsigned int i = 0; i < total.length();i++){ //iterates through input 
           (*object).increment(total.at(i)); //calls the increment method at each character read
            }

    if (input.length() < 0) { //if the read fails from stdin
        bail(10,"read from stdin failed");
    }

std :: cout << "\nCategory counts and total from STDIN\n\n";
}

void parseArgs(int argc, char *argv []){
        if(argc > 1){ //if number of arguments entered is not 1 , automatically display the help message 
                std :: cout << "This program counts the occurrences of each type of byte streaming from STDIN.\n";
                std :: cout << "Specifically, it will count occurrences of each letter (regardless of case),\n";
                std :: cout << "each digit, each whitespace, all other printable characters in the base ASCII \n";
                std :: cout << "table (i.e., not extended-ASCII), all extended-ASCII characters, and all\n";
                std :: cout << "newline characters.\n";
                std :: cout << "Usage: prog4 <someFile\n";
                std :: cout << "\tor\n";
                std :: cout << "\tprog4 <someFile\t\t(Note: type input followed by Cntl+D)\n";
                exit(0); }


        std :: cout << "\nCount object and category counts initialized\n";

}

void bail(int err, const char *message){ //bail with the error number and the message
std :: cerr << err << "-" << message;
exit(err);
}
