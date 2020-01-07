//Tariq Al-Serhan
//HW09-PartB
//Nov-27-2018
import java.util.Scanner;
import java.util.Random;
public class RemoveElements {
 public static int[] randomInput() {
  // The randomInput() method generates an array of 10 random integers between 0 to 9. 
  // Implement randomInput so that it fills the array with random integers and returns the filled array. 
  int[] a = new int[10];
  Random rgen = new Random(); //random object
  for (int i = 0; i < a.length; i++) { //for loop to enter the array
   int random = rgen.nextInt(a.length);
   a[i] = random; // assign each value in the array to a random number between 0-9
  }
  return a;
 }

 public static int[] delete(int[] arr, int index) {
  //The method delete(list,pos) takes, as input, an integer array called list and an integer called pos.  
  //It should create a new array that has one member fewer than list, 
  //and be composed of all of the same members except the member in the position pos. 

  if (index > 9 || index < 0) { //if index is out of range
   System.out.println("Index is out of range");
   return null;
  } else {
   int logicalSize = arr.length;
   for (int i = index; i < arr.length - 1; i++) {
    arr[i] = arr[i + 1];
   }
   arr[logicalSize - 1] = 0; //reset the value of the final index in the array

   logicalSize--; //decrease the logical size
   int[] newarr = new int[logicalSize]; // make a new array with the new number limit
   for (int i = 0; i < newarr.length; i++) {
    newarr[i] = arr[i]; //copy elements to new array
   }
   return newarr; //return new array
  }
 }
 public static int[] remove(int[] arr, int target) {
  //Method remove(list,target) deletes all the elements that are equal to target, 
  //returning a new list without all those new elements.
  int count = 0;
  for (int i = 0; i < arr.length; i++) {
   if (arr[i] == target) {
    count++;
    delete(arr, i); // call the delete method to deal with the index 
   }
  }
  if (count == 0) { //if target did not occur in the array
   System.out.print("number is not in the list");
  }
  return arr;
 }





 public static void main(String[] arg) {
  Scanner scan = new Scanner(System.in);
  int num[] = new int[10];
  int newArray1[];
  int newArray2[];
  int index, target;
  String answer = "";
  do {
   System.out.print("Random input 10 ints [0-9]");
   num = randomInput();
   String out = "The original array is:";
   out += listArray(num);
   System.out.println(out);

   System.out.print("Enter the index ");
   index = scan.nextInt();
   newArray1 = delete(num, index);
   String out1 = "The output array is ";
   out1 += listArray(newArray1); //return a string of the form "{2, 3, -9}"  
   System.out.println(out1);

   System.out.print("Enter the target value ");
   target = scan.nextInt();
   newArray2 = remove(num, target);
   String out2 = "The output array is ";
   out2 += listArray(newArray2); //return a string of the form "{2, 3, -9}"  
   System.out.println(out2);

   System.out.print("Go again? Enter 'y' or 'Y', anything else to quit-");
   answer = scan.next();
  } while (answer.equals("Y") || answer.equals("y"));
 }

 public static String listArray(int num[]) {
  String out = "{";
  for (int j = 0; j < num.length; j++) {
   if (j > 0) {
    out += ", ";
   }
   out += num[j];
  }
  out += "} ";
  return out;
 }
}