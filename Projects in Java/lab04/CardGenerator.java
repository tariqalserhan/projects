//Tariq Al-Serhan 
//Sep 20 2018
//lab 04

//After you generate a random number, create two String variables: a String corresponding to the name of the suit and 
//a String corresponding to the identity of the card.
//Use if statements to assign the suit name.
//Use a switch statement to assign the card identity.
//Print out the name of the randomly selected card.

public class CardGenerator {
  public static void main(String []args){ // main method
    int cardnum = (int) (Math.random() * 52  + 1); // generate a random number between 1 and 52 
    String suit = "";
    String identity = ""; // create a string for suit and another string for identity 
    
    //Use if statements to find the suit of the card 
    if ( cardnum < 14){ 
      suit = "diamonds";
    }
    else if ( cardnum < 27){
      suit = "clubs";
    }
    else if ( cardnum < 40){
      suit = "hearts";
    }
    else{
      suit = "spades";
    }
    
    //Use Switch for the identity (king, queen, jacka & ace)
    switch (cardnum) {
            case 1:  identity = "Ace";
                     break;
            case 11:  identity = "Jack";
                     break;
            case 12:  identity = "Queen";
                     break;
            case 13:  identity = "King";
                     break;
            case 14:  identity = "Ace";
                     break;
            case 24:  identity = "Jack";
                     break;
            case 25:  identity = "Queen";
                     break;
            case 26:  identity = "King";
                     break;
            case 27:  identity = "Ace";
                     break;
            case 37:  identity = "Jack";
                     break;
            case 38:  identity = "Queen";
                     break;
            case 39:  identity = "King";
                     break;
            case 40:  identity = "Ace";
                     break;
            case 50:  identity = "Jack";
                     break;
            case 51:  identity = "Queen";
                     break;
            case 52:  identity = "King";
                     break;
            default: identity = Integer.toString(cardnum%13);
                     break;
        }
        System.out.println("You picked the " + identity + " of "+ suit); //print the statement 
    }
}
  