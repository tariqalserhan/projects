//Tariq Al-Serhan
//10Oct2018
//HomeWork5

import java.util.Scanner;//import the scanner object
public class PokerHands{
  public static void main(String []args){//main method
    System.out.println("how many times should this program generate hands?");
    Scanner scan = new Scanner(System.in);
    int hands = scan.nextInt();//ask the user for number of hands
    
    //intialize all the cards to 0 (according to occurance)
    int ace=0;
    int two=0;
    int three=0;
    int four=0;
    int five=0;
    int six=0;
    int seven=0;
    int eight=0;
    int nine=0;
    int ten=0;
    int jack=0;
    int queen=0;
    int king=0;
    
    //intialize all variables needed in this program
    int count =0;//create a counter or a flag variable
    int fourOfaKind =0, threeOfaKind=0;
    int pairCount=0,onePair=0,twoPair=0;
    int card1,card2,card3,card4,card5;
    
    while(count <=hands){
   card1 = (int) (Math.random() * 52  + 1)%13;
   card2 =(int) (Math.random() * 52  + 1)%13;
   card3 = (int) (Math.random() * 52  + 1)%13;
   card4 = (int) (Math.random() * 52  + 1)%13;
   card5 = (int) (Math.random() * 52  + 1)%13;
   //Create a while loop to check for reoccurance of the same face 
   while(ace==0){
     if(card1==1){
       ace++;
     }
     if(card2==1){
       ace++;
     }
     if(card3==1){
       ace++;
     }
     if(card4==1){
       ace++;
     }
     if(card5==1){
       ace++;
     }
     if(ace==0){ //break when no aces are found
       break;
     }
   }
   
   while(two ==0){
     if(card1==2){
       two++;
     }
     if(card2==2){
       two++;
     }
     if(card3==2){
       two++;
     }
     if(card4==2){
       two++;
     }
     if(card5==2){
       two++;
     }
     if(two==0){
       break;
     }
   }
   while(three ==0){
     if(card1==3){
       three++;
     }
     if(card2==3){
       three++;
     }
     if(card3==3){
       three++;
     }
     if(card4==3){
       three++;
     }
     if(card5==3){
       three++;
     }
     if(three==0){
       break;
     }
   }
   while(four ==0){
     if(card1==4){
       four++;
     }
     if(card2==4){
       four++;
     }
     if(card3==4){
       four++;
     }
     if(card4==4){
       four++;
     }
     if(card5==4){
       four++;
     }
     if(four==0){
       break;
     }
   }
   while(five ==0){
     if(card1==5){
       five++;
     }
     if(card2==5){
       five++;
     }
     if(card3==5){
       five++;
     }
     if(card4==5){
       five++;
     }
     if(card5==5){
       five++;
     }
     if(ace==0){
       break;
     }
   }
   while(ace ==0){
     if(card1==6){
       six++;
     }
     if(card2==6){
       six++;
     }
     if(card3==6){
       six++;
     }
     if(card4==6){
       six++;
     }
     if(card5==6){
       six++;
     }
     if(six==0){
       break;
     }
   }
   while(seven ==0){
     if(card1==7){
       seven++;
     }
     if(card2==7){
       seven++;
     }
     if(card3==7){
       seven++;
     }
     if(card4==7){
       seven++;
     }
     if(card5==7){
       seven++;
     }
     if(seven==0){
       break;
     }
   }
   while(eight ==0){
     if(card1==8){
       eight++;
     }
     if(card2==8){
       eight++;
     }
     if(card3==8){
       eight++;
     }
     if(card4==8){
       eight++;
     }
     if(card5==8){
       eight++;
     }
     if(eight==0){
       break;
     }
   }
   while(nine ==0){
     if(card1==9){
       nine++;
     }
     if(card2==9){
       nine++;
     }
     if(card3==9){
       nine++;
     }
     if(card4==9){
       nine++;
     }
     if(card5==9){
       nine++;
     }
     if(nine==0){
       break;
     }
   }
   while(ten ==0){
     if(card1==10){
       ten++;
     }
     if(card2==10){
       ten++;
     }
     if(card3==10){
       ten++;
     }
     if(card4==10){
       ten++;
     }
     if(card5==10){
       ten++;
     }
     if(ten==0){
       break;
     }
   }
   while(jack==0){
     if(card1==11){
       jack++;
     }
     if(card2==11){
       jack++;
     }
     if(card3==11){
       jack++;
     }
     if(card4==11){
       jack++;
     }
     if(card5==11){
       jack++;
     }
     if(jack==0){
       break;
     }
   }
   while(queen ==0){
     if(card1==12){
       queen++;
     }
     if(card2==12){
       queen++;
     }
     if(card3==12){
       queen++;
     }
     if(card4==12){
       queen++;
     }
     if(card5==12){
       queen++;
     }
     if(queen==0){
       break;
     }
   }
     while(king==0){
     if(card1==13){
       king++;
     }
     if(card2==13){
       king++;
     }
     if(card3==13){
       king++;
     }
     if(card4==13){
       king++;
     }
     if(card5==13){
       king++;
     }
     if(king==0){
       break;
     }
   }
     //Check if there is a four of a kind or a three of a kind (only need one if statement because a four of a kind or a three of a kind can 
      //occur only once in a hand)
     if(ace == 4 || two == 4 || three == 4 || four == 4 || five == 4 || six == 4 || seven ==4 || eight == 4 || nine == 4 || ten == 4 || jack == 4 || queen == 4 || king == 4){
       fourOfaKind++;
     }
     if(ace == 3 || two == 3 || three == 3 || four == 3 || five == 3 || six == 3 || seven ==3 || eight == 3 || nine == 3 || ten == 3 || jack == 3 || queen == 3 || king == 3){
       threeOfaKind++;
     }
      //Check for pairs 
     
       if(ace == 2){
         pairCount++;
       }
        if(two == 2){
         pairCount++;
       }
       if(three == 2){
         pairCount++;
       }
       if(four == 2){
         pairCount++;
       }
       if(five == 2){
         pairCount++;
       }
       if(six == 2){
         pairCount++;
       }
       if(seven == 2){
         pairCount++;
       }
       if(eight == 2){
         pairCount++;
       }
       if(nine == 2){
         pairCount++;
       }
               
       if(ten == 2){
         pairCount++;
       }
           
       if(jack == 2){
         pairCount++;
       }
       if(queen == 2){
         pairCount++;
       }
       if(king == 2){
         pairCount++;
       }
     }
     //Check whether it is one pair or two pair
     if(pairCount == 1){
       onePair++;
     }
     if(pairCount == 2){
       twoPair++;
     }
     //add one to the counter to change the hands 
     // set all the values back to 0 (for the next loop round)
     ace=0;
     two=0;
     three=0;
     four=0;
     five=0;
     six=0;
     seven=0;
     eight=0;
     nine=0;
     ten=0;
     jack=0;
     queen=0;
     king=0;
     count++;
      
    }
    //Calculate the probability
    double prob4 = fourOfaKind/hands;
    double prob3 = threeOfaKind/hands;
    double prob2 = twoPair/hands;
    double prob1 = onePair/hands;
    //Print the result to the screen
    System.out.println("The number of loops: "+hands);
    System.out.println("The probability of Four-of-a-kind: "+prob4);
    System.out.println("The probability of Three-of-a-kind: "+prob3);
    System.out.println("The probability of Two-pair: "+prob2);
    System.out.println("The probability of One-pair: "+prob1);

  }
     }
     
   
     
       