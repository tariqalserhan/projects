//Tariq Al-Serhan
//Sep 17 2018
//HomeWork 03

//import the Scanner Method 
  import java.util.Scanner; 

  public class Pyramid{
    
// main method required for every Java program
  public static void main(String[] args) {
  
  //initiate scan to be the scanner  
  Scanner scan = new Scanner( System.in );
    
  //ask the user to input the square side length
  System.out.print("The square side of the pyramid is (input length): "); 
  //user inputs the square side length
  int length = scan.nextInt(); 
  //ask the user to input the height value
  System.out.print("The height of the pyramid is (input height): ");
  //user inputs the height
  int height = scan.nextInt();
  //calculate the volume of the pyramid
  int volume = (length * length * height)/3; 
  //print out the volume 
  System.out.println("The volume inside the pyramid is: "+volume+".");
}
}
