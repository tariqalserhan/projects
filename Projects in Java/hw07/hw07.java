//Tariq Al-Serhan 
//HW07
//30Oct2018

import java.util.Scanner;
public class hw07 {

 //Implement a sampleText() method that prompts the user to enter a string of their choosing. 
 //Store the text in a string. Output the string.
 public static String sampleText(String a) {
  String text = a;
  return text;
 }

 //Implement a printMenu() method, which outputs a menu of user options for analyzing/editing the string,
 //and returns the user's entered menu option. Each option is represented by a single character.
 public static String printMenu() {
  Scanner scan = new Scanner(System.in);
  String enter = "";


   System.out.println("MENU");
   System.out.println("c - Number of non-whitespace characters");
   System.out.println("w - Number of words");
   System.out.println("f - Find text");
   System.out.println("r - Replace all !'s");
   System.out.println("s - Shorten spaces");
   System.out.println("q - Quit");
   System.out.println("Choose an Option: \n(AGAIN Press q to QUIT)");
   enter = scan.nextLine();
  
  return enter;
 }
 
 //Implement the getNumOfNonWSCharacters() method. 
 //getNumOfNonWSCharacters() has a string as a parameter and returns the number of characters in the String, excluding all whitespac
 public static int getNumOfNonWSCharacters(String f) {
  int count = 0;
  for (int i = 0; i <= f.length() - 1; i++) {
   if (f.charAt(i) != ' ') {
    count++;
   }
  }

  return count;
 }

 //Implement the getNumOfWords() method. 
 //getNumOfWords() has a string as a parameter and returns the number of words in the string. 
 //Hint: Use a loop that steps over the letters of the String. Words end when a space is reached except for the last word in a sentence. 

 public static int getNumOfWords(String s) {
  int words = 1;
  for (int i = 0; i <= s.length() - 1; i++) {
   if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
    words++;
   }
  }

  return words;
 }

 //implement the findText() method, which has two strings as parameters. 
 //The first parameter is the text to be found in the user provided sample text, and the second parameter is the user provided sample text. 
 //The method returns the number of instances a word or phrase is found in the string.

 public static int findText(String f, String txt) {
  int instances = 0;
  for (int i = 0; i <= txt.length() - 1 - (f.length()); i++) { //make sure it doesn't cause an error
   if (txt.substring(i, i + f.length()).equals(f)) { //use substring method for Strings
    instances++;
   }
  }
  return instances;
 }

 //Implement the replaceExclamation() method. 
 //replaceExclamation() has a string parameter and returns a string which replaces each '!' character in the string with a '.' character. 
 // replaceExclamation() DOES NOT output the string. 

 public static String replaceExclamation(String txt) {
  for (int i = 0; i <= txt.length() - 1; i++) {
   if (txt.charAt(i) == '!') {
    txt.replace("!", "a"); //use replace method for Strings
   }
  }
  return txt;
 }

 
 //Implement the shortenSpace() method. 
 // shortenSpace() has a string parameter and returns a string that replaces all sequences of 2 or more spaces with a single space. 
 //shortenSpace() DOES NOT output the string. Call shortenSpace() if the user enters "s" in the menu, and then output the edited string.

 public static String shortenSpace(String txt){
  String shorten=txt.replaceAll("\\s+", " ");//Use replace all and \\s++(which account for one or more space
  return shorten;
 }
 
 
 //main method
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.println("Please enter a sample text");
  String sample = scan.nextLine();
  
  //Call printMenu() in the main() method.
  String letter = printMenu();
  while(!letter.equals("q")){//If an invalid character is entered, continue to prompt for a valid choice.
    
  //Call getNumOfNonWSCharacters() if the user enters "c" in the menu. 
  if (letter.equals("c")) {
   System.out.println("Number of non-whitespace characters: "+getNumOfNonWSCharacters(sample));
   break;
  }
  //Call getNumOfWords() if the user enters "w" in the menu.
  else if(letter.equals("w")){
   System.out.println("Number of words: "+getNumOfWords(sample));
   break;
  }
 //If the user enters "f" in the menu, prompt the user for a word or phrase to be found and then call findText(). 
  else if(letter.equals("f")){
   System.out.println("Enter a word or phrase to be found:") ;
   String phrase = scan.nextLine(); 
   System.out.println("\""+phrase+"\" instances :"+findText(phrase, sample));
   break;
  }
 //Call replaceExclamation() if the user enters "r" in the menu and then output the edited string.  
  else if(letter.equals("r")){
   System.out.println("Edited text: "+replaceExclamation(sample));
   break;
  }
 //Call shortenSpace() if the user enters "s" in the menu, and then output the edited string.
  else if(letter.equals("s")){
   System.out.println("Edited text: "+shortenSpace(sample));
   break;
  }
  letter = printMenu();
}
  }
 }
 
  