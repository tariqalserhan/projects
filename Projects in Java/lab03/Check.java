//Tariq Al-Serhan
//Sep 13 2018
//lab03

import java.util.Scanner; //import the Scanner Method 
//Write a program that uses the Scanner class to obtain from the user the original cost of the check, 
//the percentage tip they wish to pay, and the number of ways the check will be split. 
//Then determine how much each person in the group needs to spend in order to pay the check.

   public class Check{
    			// main method required for every Java program
   			public static void main(String[] args) {
   Scanner myScanner = new Scanner( System.in );//initiate myScanner to be the scanner
          
   System.out.print("Enter the original cost of the check in the form xx.xx: ");// ask the user to input the original cost
   double checkCost = myScanner.nextDouble();// user inputs the check cost
          
   System.out.print("Enter the percentage tip that you wish to pay as a whole number (in the form xx): " );// ask the user to enter the percentage tip 
          
   double tipPercent = myScanner.nextDouble();// user inputs the percentage check 
   tipPercent /= 100; // convert the percentage into a decimal value
     
   System.out.print("Enter the number of people who went out to dinner: ");// ask the user for the number of people this check is splitting to 
   int numPeople = myScanner.nextInt();// user inputs number of people
          
   double totalCost; //initialize a variable for total Cost
   double costPerPerson; //initialize a variable for cost per person
   int dollars,   //whole dollar amount of cost 
   dimes, pennies; //for storing digits
          //to the right of the decimal point 
          //for the cost$ 
   totalCost = checkCost * (1 + tipPercent);//Calculate the total cost 
   costPerPerson = totalCost / numPeople;// calculate the cost per person 
   
   dollars=(int)costPerPerson; //get the whole amount, dropping decimal fraction
   //get dimes amount, e.g., 
   // (int)(6.73 * 10) % 10 -> 67 % 10 -> 7
   //  where the % (mod) operator returns the remainder
   //  after the division:   583%100 -> 83, 27%5 -> 2 
   dimes=(int)(costPerPerson * 10) % 10;
   pennies=(int)(costPerPerson * 100) % 10;
   System.out.println("Each person in the group owes $ " + dollars + "." + dimes + pennies);


}  //end of main method   
  	} //end of class
