//Tariq Al-Serhan
//HW09-PartA
//Nov-27-2018

import java.util.Random; //import the Random object
import java.util.Scanner; //import the Scanner object

public class CSE2Linear {

 public static void print(int[] array) {// method to print the array when called 
   
  for (int e: array) { //for each loop to access all elements of the array
   System.out.print(e + " ");
  }
  
 }
 
 
 public static int linearSearch(int search, int array[]) { // linear search method
  for (int i = 0; i < array.length; i++)
   if (array[i] == search) {
    System.out.println("The search took " + (i + 1) + " iterations"); //print out the number of iterations
    return i; //the index at which the number was found

   }
  return -1; // if the number was not found in the array
 }
 
 
 public static int binarySearch(int search, int[] array) { // binary search method
  int start = 0; //intial index of the array (far left)
  int end = array.length - 1; //final index of array(far right)
  int count = 0; //count for the number of iterations
  while (start <= end) {
   int middle = (start + end) / 2; //cut the array in two halves 
   if (search < array[middle]) { //search in right half
    end = middle - 1; //make the search more specific 
    count++; //add to the number of iterations 
   }
   if (search > array[middle]) { //search in the left half 
    start = middle + 1; // keep on making the search more specific 
    count++; // add to the number of iterations
   }
   if (search == array[middle]) { //when the value user is looking for is found 
    count++;
    return count;
   }
  }
  System.out.println("The search took " + count + " iterations"); //if not found, still be able to print the number of iterations
  return -1;
 }
 
 public static void scramble(int[] array) { //scramble method 
  Random rgen = new Random(); //random object
  int temp = 0; // temporary value
  for (int i = 0; i < array.length; i++) { //for loop to enter the array
   int random = rgen.nextInt(array.length);
   temp = array[random]; // need a carrier to switch the contents of the array
   array[random] = array[i];
   array[i] = temp; //switch the values
  }
 }


 public static void main(String[] args) { // main method
  int[] grades = new int[15];
  System.out.println("Please enter 15 ints for students’ final grades in CSE2 in ascending order");
  Scanner scan = new Scanner(System.in);
  int num = 0;
  for (int i = 0; i < 15; i++) {
   num = scan.nextInt(); //print an error message if the user enters anything other than an int (automatic because only ints could be taken)

   if (num > 100 || num < 0) { //Print a different error message for an int that is out of the range from 0-100
    System.out.println("Error: number is out of range");
    break;
   }
   grades[i] = num;
  }
  for (int i = 1; i < 15; i++) { //Check for the third error message 
   if (grades[i] < grades[i - 1]) {
    System.out.println("Error: the numbers are not in ascending order"); //a third error message if the int is not greater than or equal to the last int.
   }
  }

  print(grades); //print the array

  System.out.println("\nEnter a grade to search for: "); //prompt the user to enter a grade to be searched for
  int x = scan.nextInt(); //user input
  if (binarySearch(x, grades) == -1) { //do binary search
   System.out.print(x + " was not found in the list");
  } else {
   System.out.print(x + " was found in the list after " + binarySearch(x, grades) + " iterations");
  }
  
  System.out.println("\nScrambled: ");
  scramble(grades); //scramble array
  print(grades); //print array
  
  System.out.println("\nEnter a grade to search for: "); //prompt the user to enter a grade to be searched for
  int y = scan.nextInt();
  if (linearSearch(y, grades) == -1) { //do a linear search
   System.out.println(y + " was not found in the list ");
  } else {
   System.out.println(y + " was found in the list");
  }

 }
} //end of program