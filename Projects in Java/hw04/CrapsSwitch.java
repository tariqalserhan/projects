//Tariq Al-Serhan
//hw04
//Sep 25 2018
//Part B

//import the Scanner class
import java.util.Scanner;

public class CrapsSwitch {
  
  //install the main method of the class
  public static void main (String []args){
    
    // create a Scanner object 
    Scanner scan = new Scanner ( System.in);
   
    //Ask the user to either randomly generate the numbers or manually plugging in the numbers
    System.out.println("To randomly cast dice, please enter \"1\"\nTo input the two dice manually, please enter \"2\"");
    int input =  scan.nextInt();
    
    //Follow the paths of either case, the first is random the second in the manual input of values    
    
    switch(input){
        
      //In case the user wants to pick randomly (case1)
      case 1: 
       //generate the two random numbers between 1-6 exclusive
      int randnum1 = (int)(Math.random()*6+1); 
      int randnum2 = (int) (Math.random()*6+1);
     
      //print out the two random numbers
      System.out.println("First Random Number: "+randnum1);
      System.out.println("Second Random Number: "+randnum2);
      
      // check for the 6 cases die 1 can be along with the 6 other cases die 2 can be. Assign each with the correct statement. 
      switch(randnum1){
          
        case 1: 
          switch(randnum2){ 
                case 1:System.out.println("Snake Eyes");
                  break;
                case 2:System.out.println("Ace Deuce");
                  break;
                case 3:System.out.println("Easy Four");
                  break;
                case 4:System.out.println("Fever Five");
                  break;
                case 5:System.out.println("Easy Six");
                  break;
                case 6:System.out.println("Seven out");
                  break;
              }
          break;
          
          case 2: 
            switch(randnum2){
                case 1:System.out.println("Ace Deuce");
                    break;
                case 2:System.out.println("Hard four");
                    break;
                case 3:System.out.println("Fever Five");
                    break;
                case 4:System.out.println("Fever Five");
                    break;
                case 5:System.out.println("Seven out");
                    break;
                case 6:System.out.println("Easy Eight");
                    break;
              }
          break;
          
          case 3: 
            switch(randnum2){
                case 1:System.out.println("Easy Four");
                    break;
                case 2:System.out.println("Fever five");
                    break;
                case 3:System.out.println("Hard six");
                    break;
                case 4:System.out.println("Seven out");
                    break;
                case 5:System.out.println("Easy Eight");
                    break;
                case 6:System.out.println("Nine");
                    break;
              }
          break;
          
          case 4: 
            switch(randnum2){
              case 1:System.out.println("Fever Five");
                  break;
              case 2:System.out.println("Easy Six");
                  break;
              case 3:System.out.println("Seven out");
                  break;
              case 4:System.out.println("Hard Eight");
                  break;
              case 5:System.out.println("Nine");
                  break;
              case 6:System.out.println("Easy Ten");
                  break;// need to break after each case of randnum2 
            }
          break; // Make sure to break after each case of randnum1 
          
          case 5: 
            switch(randnum2){
                case 1:System.out.println("Easy Six");
                case 2:System.out.println("Seven out");
                case 3:System.out.println("Easy Eight");
                case 4:System.out.println("Nine");
                case 5:System.out.println("Hard Ten");
                case 6:System.out.println("Yo-Leven");
              }
          break;
          
          case 6: 
             switch(randnum2){
                case 1:System.out.println("Seven out");
                    break;
                case 2:System.out.println("Easy Eight");
                    break;
                case 3:System.out.println("Nine");
                    break;
                case 4:System.out.println("Easy Ten");
                    break;
                case 5:System.out.println("Yo-Leven");
                    break;
                case 6:System.out.println("Boxcars");
                    break;
        }
          break; 
       //no need for a default because the random generator will never go above 6 or below 1 
      }
        
        break; //for case 1 (random)
        
      
     case 2:
      //Ask user to input both of the values
      System.out.println("Please enter the two values, make sure that each falls between 1-6");
      int usernum1 = scan.nextInt(); 
      int usernum2 = scan.nextInt();
      
      //Follow the table for the number combination generator using if and else if statements 
      switch(usernum1){
        case 1:   
          switch(usernum2){
                case 1:System.out.println("Snake Eyes");
                  break;
                case 2:System.out.println("Ace Deuce");
                  break;
                case 3:System.out.println("Easy Four");
                  break;
                case 4:System.out.println("Fever Five");
                  break;
                case 5:System.out.println("Easy Six");
                  break;
                case 6:System.out.println("Seven out");
                  break;
          }
          break;
          case 2: 
            switch(usernum2){
                case 1:System.out.println("Ace Deuce");
                    break;
                case 2:System.out.println("Hard four");
                    break;
                case 3:System.out.println("Fever Five");
                    break;
                case 4:System.out.println("Fever Five");
                    break;
                case 5:System.out.println("Seven out");
                    break;
                case 6:System.out.println("Easy Eight");
                    break;
        }
          break;
          
          case 3: 
            switch(usernum2){
                case 1:System.out.println("Easy Four");
                    break;
                case 2:System.out.println("Fever five");
                    break;
                case 3:System.out.println("Hard six");
                    break;
                case 4:System.out.println("Seven out");
                    break;
                case 5:System.out.println("Easy Eight");
                    break;
                case 6:System.out.println("Nine");
                    break;
        }
          break;
          
          case 4: 
            switch(usernum2){
                case 1:System.out.println("Fever Five");
                    break;
                case 2:System.out.println("Easy Six");
                    break;
                case 3:System.out.println("Seven out");
                    break;
                case 4:System.out.println("Hard Eight");
                    break;
                case 5:System.out.println("Nine");
                    break;
                case 6:System.out.println("Easy Ten");
                    break;
        }
          break;
          
          case 5:
           switch(usernum2){
                case 1:System.out.println("Easy Six");
                    break;
                case 2:System.out.println("Seven out");
                    break;
                case 3:System.out.println("Easy Eight");
                    break;
                case 4:System.out.println("Nine");
                    break;
                case 5:System.out.println("Hard Ten");
                    break;
                case 6:System.out.println("Yo-Leven");
                    break;
              }
          break;
          
          case 6: 
            switch(usernum2){
                case 1:System.out.println("Seven out");
                    break;
                case 2:System.out.println("Easy Eight");
                    break;
                case 3:System.out.println("Nine");
                    break;
                case 4:System.out.println("Easy Ten");
                    break;
                case 5:System.out.println("Yo-Leven");
                    break;
                case 6:System.out.println("Boxcars");
                    break;
              }
          break;
          default: System.out.println("WRONG INPUT!");
                     break;// create a defaullt if any of the inputted numbers are not in range 
      }
        break; // for case 2 of the program (manual input)
      default: System.out.println("WRONG INPUT!");
                     break;
      }
   
  }
}//ending the program 
     