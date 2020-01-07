//Tariq Al-Serhan
//November 2018

public class Arrays{
  public static void main(String [] args){//make the arrays with 100 size
    int [] arrayOne = new int[100];
    int [] arrayTwo = new int[100];
    int count =0;
    for(int i=0;i<arrayOne.length;i++){//set frirst array
      arrayOne[i]= (int)(Math.random() * 100) + 1;
      System.out.print(arrayOne[i] + " ");
  }
    System.out.println();
    
    for(int f=0; f<100;f++){//check for occurances using a counter
      for(int j=0;j<100;j++){
        if(arrayOne[j]==f){
          count++;
        }
        else{
          arrayTwo[f]=0;
        }
      }
      arrayTwo[f] =count;
      count =0;
    }
    for(int g=0; g<100; g++){
      if(arrayTwo[g]!=0){
        System.out.println(g + " occured " + arrayTwo[g]+ " times");
}
}
  }
}