//Tariq Al-Serhan
//Oct 23 2018
//HW06

//Import the Scanner object
import java.util.Scanner; 

//Create a class and call it EnryptedX
public class EncryptedX{
  
  //Main Method
  public static void main(String []args){
    
    //Ask the user for an integer between 0 - 100. Validate input. 
    //This will be the size of the square measured by the number of stars.
    System.out.println("Please enter a valid number between 1-100");
    
    //Create a scanner object
    Scanner scan = new Scanner(System.in);
    
    //initialize variables needed
    int count =0;
    String m ="";
    
    //User's input for the size of the square
    int num = scan.nextInt();
    
    //Check if the number falls in the valid range
    if(num >= 0 && num <= 100){
      
      //Create a while loop for the number of lines to be printed
      while(count <= num+1){
        //Create a for loop for each row
    for(int i=0; i<=num; i++){
      m+="*";
    }
    
    //for each row modify that it replaces the inteded character in the row to become a space using substring
        m=m.substring(0,count)+" "+m.substring(count); 
        m=m.substring(0,(m.length()-1)-count)+" "+m.substring(m.length()-count);
        
    //print the row after modifying
    System.out.print(m);
    
    //new Line
    System.out.println();
    
    //Counter increases
    count++;
    
    // the string resets
    m="";
    
      }//End of while loop
      
    }//End of If statement
    else{
      System.out.println("You've entered an invalid value");
    }
  }
}//End of program