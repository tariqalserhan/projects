//Tariq Al-Serhan
//Sep/17/2018
//HW03

import java.util.Scanner;
//Program #1. Hurricanes drop a tremendous amount of water on areas of land.  
//Write a program that asks the user for doubles that represent the number of acres of land affected by hurricane precipitation and 
//how many inches of rain were dropped on average.  Convert the quantity of rain into cubic miles.
public class Convert{
   			public static void main(String[] args) {// main method required for every Java program

Scanner scan = new Scanner (System.in);//initiate scan to be the scanner

System.out.print("Enter the affected area in acres: ");//ask the user for the affected area in acres
double area = scan.nextDouble();// the user inputs the value
System.out.print("Enter the rainfall in the affected area: ");// ask the user for the rainfall amount 
double rainfall = scan.nextDouble(); //the user inputs the rainfall amount
double gals = area * rainfall; 
double convert = 40549998.0;  //there are 40549998.0 gals/ cubic miles             
double miles = gals / convert; // convert to cubic miles 
System.out.println(miles + " cubic miles"); // print out the amount in cubic miles
  
        }
                   }
