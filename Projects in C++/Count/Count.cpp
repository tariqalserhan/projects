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
#include <iostream>  // for C++ I/O
#include <vector>    // for vector

    Count::Count(){ //Count Constructor to initialize the variables we need in this program 
         numOther = 0;
         numExtended = 0;
         numNewline = 0;
         numWhiteSpace = 0;
         numLetter.resize(26,0); //we need a vector of size 26 for the letters
         numDigit.resize(10,0); //we need a vector of size 10 for the digits 

  }
    void Count :: increment(char character){ //The increment method 
    unsigned int value = (unsigned int)(character); //gets the ascii value of the character
    switch(value){ //switch cases to read the ascii values and increment the correct variables
        case 0 ... 9:
            numWhiteSpace++;
            break;
        case 10:
            numNewline++;
            break;
        case 11 ... 32:
            numWhiteSpace++;
            break;
        case 33 ... 47:
            numOther++;
            break;
        case 48 ... 57:
            numDigit[value - 48]++;
            break;
        case 58 ... 64:
            numOther++;
            break;
        case 65 ... 90:
            numLetter[value - 65]++;
            break;
        case 91 ... 96:
            numOther++;
            break;
        case 97 ... 122:
            numLetter[value -97] ++;
            break;
        case 123 ... 126:
            numOther++;
            break;
        case 127 :
            numWhiteSpace++;
            break;
        default: //if the character is extended we use default becasue there is no standard "Extended ASCII"
            numExtended++;
            break;
    }

}
    unsigned int Count :: getTotal(){ //get the total characters count
    unsigned int total = 0; //initialize the total value of characters to 0  

   total =(numWhiteSpace + numOther+ (numExtended/2) + numNewline); //numExtended will count as 2 bytes since our elements will range from 0 - 255(unsigned int)

    for( int i = 0; i < 26; i++){
        total = total + numLetter[i];
    }
    for(int i = 0; i < 10; i++){
        total = total + numDigit[i];
    }

    return total;
    }

    std::ostream & operator <<(std::ostream &out, Count &object){ //Use the friend method to set the output statement to support the printing of counts
    for(int i = 0; i< 26; i++){
        out <<"Number of letter "<<(char)(97 + i) <<":"<<"\t\t    "<<object.numLetter[i]<<std::endl;
    }

    for(int i = 0; i< 10; i++){
        out <<"Number of digit "<<(char)(48 + i) <<":"<<"\t\t    "<<object.numDigit[i]<<std::endl;
    }

    out <<"Number of white spaces"<<":"<<"\t\t    "<<object.numWhiteSpace<<std::endl;
    out <<"Number of other characters"<<":"<<"\t    "<<object.numOther<<std::endl;
    out <<"Number of extended characters"<<":"<<"\t    "<<object.numExtended/2<<std::endl;
    out <<"Number of newline characters"<<":"<<"\t    "<<object.numNewline<<std::endl;
    out <<"\n\nTotal number of characters"<<":"<<"\t    "<<object.getTotal()<<std::endl;
    return out;
    }

    Count :: ~Count() {  //the destructor 
        std :: cout << *this;
        std::cout << "Count object Destroyed \n" << std::endl;
    }
