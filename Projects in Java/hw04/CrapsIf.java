//Tariq Al-Serhan
//hw04
//Sep 25 2018
//Part A

//import the Scanner class
import java.util.Scanner;

public class CrapsIf {
  
  //install the main method of the class
  public static void main (String []args){
    
    // create a Scanner object 
    Scanner scan = new Scanner ( System.in);
   
    //Ask the user to either randomly generate the numbers or manually plugging in the numbers
    System.out.println("To randomly cast dice, please write \"random\"\nTo input the two dice manually, please write \"two dice\"");
     String input =  scan.nextLine();
    
    //Check if the string the user inputs is "random" 
    if(input.equals("random")){
      
      //generate the two random numbers between 1-6 exclusive
      int randnum1 = (int)(Math.random()*6+1); 
      int randnum2 = (int) (Math.random()*6+1);
      
      //print out the two random numbers
      System.out.println("First Random Number: "+randnum1);
      System.out.println("Second Random Number: "+randnum2);
      
      //Follow the table for the number combination generator using if and else if statements 
      
      if(randnum1 == 1 && randnum2 == 1){
      System.out.println("Snake Eyes");
      }
      else if((randnum1 == 1 && randnum2 == 2 )|| (randnum1 == 2 && randnum2 == 1 )){
      System.out.println("Ace Deuce");
      }
      else if((randnum1 == 1 && randnum2 == 3) || (randnum1 == 3 && randnum2 == 1) ){
      System.out.println("Easy Four");
      }
      else if((randnum1 == 1 && randnum2 == 4) || (randnum1 == 4 && randnum2 == 1) ){
      System.out.println("Fever Five");
      }
      else if((randnum1 == 1 && randnum2 == 5) || (randnum1 == 5 && randnum2 == 1) ){
      System.out.println("Easy Six");
      }
      else if((randnum1 == 1 && randnum2 == 6) || (randnum1 == 6 && randnum2 == 1) ){
      System.out.println("Seven out");
      }
      else if((randnum1 == 2 && randnum2 == 2) ){
      System.out.println("Hard four");
      }
      else if((randnum1 == 2 && randnum2 == 3) || (randnum1 == 3 && randnum2 == 2) ){
      System.out.println("Fever five");
      }
      else if((randnum1 == 2 && randnum2 == 4) || (randnum1 == 4 && randnum2 == 2) ){
      System.out.println("Easy six");
      }
      else if((randnum1 == 2 && randnum2 == 5) || (randnum1 == 5 && randnum2 == 2) ){
      System.out.println("Seven out");
      }
      else if((randnum1 == 2 && randnum2 == 6) || (randnum1 == 6 && randnum2 == 2) ){
      System.out.println("Easy Eight");
      }
      else if((randnum1 == 3 && randnum2 == 3) ){
      System.out.println("Hard six");
      }
      else if((randnum1 == 3 && randnum2 == 4) || (randnum1 == 4 && randnum2 == 3) ){
      System.out.println("Seven out");
      }
      else if((randnum1 == 3&& randnum2 == 5) || (randnum1 == 5 && randnum2 == 3) ){
      System.out.println("Easy Eight");
      }
      else if((randnum1 == 3 && randnum2 == 6) || (randnum1 == 6 && randnum2 == 3) ){
      System.out.println("Nine");
      }
      else if((randnum1 == 4 && randnum2 == 4) ){
      System.out.println("Hard Eight");
      }
      else if((randnum1 == 4 && randnum2 == 5) || (randnum1 == 5 && randnum2 == 4) ){
      System.out.println("Nine");
      }
      else if((randnum1 == 4&& randnum2 == 6) || (randnum1 == 6 && randnum2 == 4) ){
      System.out.println("Easy Ten");
      }
      else if((randnum1 == 5 && randnum2 == 5)){
      System.out.println("Hard Ten");
      }
      else if((randnum1 == 5 && randnum2 == 6) || (randnum1 == 6 && randnum2 == 5) ){
      System.out.println("Yo-leven");
      }
      else if((randnum1 == 6 && randnum2 == 6) || (randnum1 == 3 && randnum2 == 1) ){
      System.out.println("Boxcars");
      }
      
    // end of first if statement
    }
    
    //Use else if to check if the first condition was not met if the string equals "two dice"
  else if(input.equals("two dice")){
    
    //Ask user to input both of the values
    System.out.println("Please enter the two values, make sure that each falls between 1-6");
      int usernum1 = scan.nextInt(); 
      int usernum2 = scan.nextInt();
    
    //Check whether the values are within range
    if(usernum1 >6 || usernum2 >6){
      System.out.println("Wrong Input");
    }
     
    //follow the combination generator using else if statements 
      else if(usernum1 == 1 && usernum2 == 1){
        System.out.println("Snake Eyes");
      }
      else if((usernum1 == 1 && usernum2 == 2 )|| (usernum1 == 2 && usernum2 == 1 )){
        System.out.println("Ace Deuce");
      }
      else if((usernum1 == 1 && usernum2 == 3) || (usernum1 == 3 && usernum2 == 1) ){
        System.out.println("Easy Four");
      }
      else if((usernum1 == 1 && usernum2 == 4) || (usernum1 == 4 && usernum2 == 1) ){
        System.out.println("Fever Five");
      }
      else if((usernum1 == 1 && usernum2 == 5) || (usernum1 == 5 && usernum2 == 1) ){
        System.out.println("Easy Six");
      }
      else if((usernum1 == 1 && usernum2 == 6) || (usernum1 == 6 && usernum2 == 1) ){
        System.out.println("Seven out");
      }
      else if((usernum1 == 2 && usernum2 == 2) ){
        System.out.println("Hard four");
      }
      else if((usernum1 == 2 && usernum2 == 3) || (usernum1 == 3 && usernum2 == 2) ){
        System.out.println("Fever five");
      }
     else if((usernum1 == 2 && usernum2 == 4) || (usernum1 == 4 && usernum2 == 2) ){
        System.out.println("Easy six");
      }
      else if((usernum1 == 2 && usernum2 == 5) || (usernum1 == 5 && usernum2 == 2) ){
        System.out.println("Seven out");
      }
      else if((usernum1 == 2 && usernum2 == 6) || (usernum1 == 6 && usernum2 == 2) ){
        System.out.println("Easy Eight");
      }
      else if((usernum1 == 3 && usernum2 == 3) ){
        System.out.println("Hard six");
      }
       else if((usernum1 == 3 && usernum2 == 4) || (usernum1 == 4 && usernum2 == 3) ){
        System.out.println("Seven out");
      }
       else if((usernum1 == 3&& usernum2 == 5) || (usernum1 == 5 && usernum2 == 3) ){
        System.out.println("Easy Eight");
      }
      else if((usernum1 == 3 && usernum2 == 6) || (usernum1 == 6 && usernum2 == 3) ){
        System.out.println("Nine");
      }
       else if((usernum1 == 4 && usernum2 == 4) ){
        System.out.println("Hard Eight");
      }
      else if((usernum1 == 4 && usernum2 == 5) || (usernum1 == 5 && usernum2 == 4) ){
        System.out.println("Nine");
      }
      else if((usernum1 == 4&& usernum2 == 6) || (usernum1 == 6 && usernum2 == 4) ){
        System.out.println("Easy Ten");
      }
       else if((usernum1 == 5 && usernum2 == 5)){
        System.out.println("Hard Ten");
      }
      else if((usernum1 == 5 && usernum2 == 6) || (usernum1 == 6 && usernum2 == 5) ){
        System.out.println("Yo-leven");
      }
       else if((usernum1 == 6 && usernum2 == 6) || (usernum1 == 3 && usernum2 == 1) ){
        System.out.println("Boxcars");
      }
    }
    
    // If user does not enter random or two dice, their input is incorrect
    else {
      System.out.println("Your input is incorrect!"); 
    }
     
  }
}//end of program
      
      