import java.util.Scanner;
public class ConveyorBelt{
  public static void main(String[]args){
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Please enter the following information about your class");
    //ask for the course number, department name, the number of times it meets in a week, 
    //the time the class starts, the instructor name, and the number of students.
    System.out.println("Please enter the course number");
    int coursenum = 0;
    int flag = 0;
    while(flag = 1){
      if(myScannerhasNextInt()){
        coursenum = myScanner.nextInt();
        flag = -1;
      }
      else{
    
    while (!myScanner.hasnextInt()){
    myScanner.next();
    }
    }
  }
  }
}
