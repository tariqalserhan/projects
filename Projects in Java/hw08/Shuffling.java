//Tariq Al-Serhan
//Nov-14-2018
//HW08

import java.util.Scanner; //import the scanner class 
import java.util.Random; // import the random class 
public class Shuffling {

 public static void printArray(String[] anArray) {
  for (String i: anArray) { //for each loop
   System.out.print(i + " ");
  }
 }

 //The method shuffle(list) shuffles the elements of the list by continuously randomize an index number of list (that is not zero) 
 //and swaps the element at that index with the first element (at index 0). 
 //Swap however many times you like, but choose > 50 times since you want the deck of 52 cards well shuffled.

 public static void shuffle(String[] array) {

  Random rgen = new Random(); //random object
  String temp = "";
  for (int i = 0; i < array.length; i++) { //for loop to enter the array
   int random = rgen.nextInt(array.length);
   temp = array[random]; // need a carrier to switch the contents of the array
   array[random] = array[i];
   array[i] = temp;
  }
 }

 //The method getHand(list, index, numCards) returns an array that holds the number of cards specified in numCards.
 //Cards should be taken off at the end of the list of cards. For example, when this method is first invoked where numCards = 2, 
 //the card at index 51 and index 50 should be returned within an array. 
 //At the second invocation of getHand() the index value passed into getHand should be 49. 
 //Note the index passed into this method is the last index value of the array. Index should change in the main method. 

 public static String[] getHand(String[] list, int index, int numCards) {
  String[] newlist = new String[numCards]; //make a new array
  for (int i = 0; i < numCards; i++) { //for loop to access the array
   newlist[i] = list[index]; //copy the values into the array
   index--; //minus the index every time so it moves to the next card (52 then 51)
  }
  return newlist; //return the new array
 }


 public static void main(String[] args) { //main method
  Scanner scan = new Scanner(System.in);
  //suits club, heart, spade or diamond 
  String[] suitNames = {
   "C",
   "H",
   "S",
   "D"
  };
  String[] rankNames = {
   "2",
   "3",
   "4",
   "5",
   "6",
   "7",
   "8",
   "9",
   "10",
   "J",
   "Q",
   "K",
   "A"
  };
  String[] cards = new String[52]; //intialize the array of cards with 52 as size
  String[] hand = new String[5]; // initialize the array of hand with 5 as size 
  int numCards = 5; // variables needed in the program
  int again = 1;
  int index = 51;
  for (int i = 0; i < 52; i++) {
   cards[i] = rankNames[i % 13] + suitNames[i / 13];
   //System.out.print(cards[i]+" "); 
  }
  System.out.println("The deck:");
  printArray(cards);
  shuffle(cards);
  System.out.println(); //extra lines for clarity in output
  System.out.println();
  System.out.println("Shuffled:");
  printArray(cards);
  System.out.println();
  System.out.println();
  while (again == 1) { //loop through if user inputs 1 
   if (numCards > index + 1) { //If numCards is greater than the number of cards in the deck, create a new deck of cards.
    for (int i = 0; i < 52; i++) { //for loop for making the cards
     cards[i] = rankNames[i % 13] + suitNames[i / 13];
    }
    shuffle(cards); //call shuffle method
    index = 51;//set index back to 51
   }
   hand = getHand(cards, index, numCards); //call the get hand method
   printArray(hand); //call print method
   index = index - numCards;
   System.out.println("\n\nEnter a 1 if you want another hand drawn"); //print out whether user wants another hand 
   again = scan.nextInt(); //ask user for input
  }
 }
}