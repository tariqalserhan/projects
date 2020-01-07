//Tariq Al-Serhan
//Lab09
//November -15

public class lab09{
//Create a method called copy(), which accepts an integer array as input, and returns an integer array as output. 
//It should declare and allocate a new integer array that is the same length as the input, 
//use a for-loop to copy each member of the input to the same member in the new array.  Finally, it should return the new array as output.
public static int [] copy(int []arr){
  int [] newarr = new int [arr.length];
  for(int i = 0; i<arr.length; i++){
    newarr[i]=arr[i];
  }
  return newarr;
}
    
//Create a method, inverter(), which reverses the order of an array.  
//Inverter should work by accepting an array of integers as input.  
//Then it should systematically swap the first member of the input array with the last member,
//the second member of the input array with the second-to-last member, and so on.  
//Therefore it modifies the memory pointed to by the array input.  It returns void.
public static void inverter(int []array){
   int temp;
  for(int i = 0; i<array.length/2; i++){//swap and stop and midpoint
    temp = array[i];// need a carrier to switch the contents of the array
    array[i]=array[array.length-i-1] ;
    array[array.length-i-1] = temp;
 }
}
/*Create a second method, inverter2(), which first uses copy() to make a copy of the input array.  
 * Then it uses a copy of the code from inverter() to invert the members of the copy. 
 * Finally, it returns the copy as output.
 */
public static int [] inverter2(int[]arr1){
  int [] arr = copy(arr1);
  inverter(arr1);
  return arr;
}
/*Create a method called print() which accepts any integer array as input, and returns nothing. 
 * Use a for-loop to print all members of the array.
 * 
 */
public static void print (int []arr){
  for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
  }
  System.out.println();
}
    
/*In your main method, declare a literal integer array of length at least 8 and make two copies of it using the copy() method, called array0, array1, array2.
 */
  public static void main(String []args){
    int[]array0 = {1,2,3,4,5,6,7,8};
    int[]array1 = copy(array0);
    int[]array2 = copy(array0);
    
    
//Pass array0 to inverter() and print it out with print().  Do not assign the output of inverter to anything.
 inverter(array0);
 print(array0);
 
//Pass array1 to inverter2() and print it out with print().  Do not assign the output of inverter to anything.
 inverter2(array1);
 print(array1);
 
//Pass array2 to inverter2() and assign the output to array3.  Array3 does not require an allocation, just declaration.  Print out array3 with print().
 int []array3 = inverter2(array2);
 print(array3);

}
}
