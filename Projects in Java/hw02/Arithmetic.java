//Tariq Al-Serhan
//Sep 11 2018
//HomeWork 02 
public class Arithmetic{
  public static void main(String[]args){ 
//Number of pairs of pants
int numPants = 3;
//Cost per pair of pants
double pantsPrice = 34.98;

//Number of sweatshirts
int numShirts = 2;
//Cost per shirt
double shirtPrice = 24.99;

//Number of belts
int numBelts = 1;
//cost per belt
double beltCost = 33.99;

//the tax rate
double paSalesTax = 0.06;
    
//Total cost of each kind of item (i.e. total cost of pants, etc)
  double totalCostOfPants = (numPants * pantsPrice);//total cost of pants
  double totalCostOfShirts = (numShirts * shirtPrice); // total cost of shirts
  double totalCostOfBelts = (numBelts * beltCost);//total cost of belts 
    
//Sales tax charged buying all of each kind of item (i.e. sales tax charged on belts)
  double salesTaxesPants = (totalCostOfPants * paSalesTax); //sales taxes of pants purchase
  double salesTaxesShirts = (totalCostOfShirts * paSalesTax); //sales taxes of shirts purchase
  double salesTaxesBelts = (totalCostOfBelts * paSalesTax); // sales taxes of belts purchase
// Make the float number look nicer 
    salesTaxesPants = salesTaxesPants * 100;
    salesTaxesPants = (int) salesTaxesPants/100.0;
    salesTaxesShirts = salesTaxesShirts * 100;
    salesTaxesShirts = (int) salesTaxesShirts/100.0;
    salesTaxesBelts = salesTaxesBelts * 100;
    salesTaxesBelts = (int) salesTaxesBelts/100.0;
    
//Total cost of purchases (before tax)
  double totalCost = (totalCostOfPants + totalCostOfShirts + totalCostOfBelts);
//Total sales tax
  double totalTaxes = (salesTaxesPants + salesTaxesShirts + salesTaxesBelts);
//Total paid for this transaction, including sales tax.
  double totalPaid = (totalCost + totalTaxes);
    
//display the cost of each of item type and the total sales tax paid for buying all of that item
  System.out.println("Total Cost of Pants: $" + totalCostOfPants + ",Total sales taxes for pants: $" + salesTaxesPants);
  System.out.println("Total Cost of Shirts: $" + totalCostOfShirts + ",Total sales taxes for shirts: $" + salesTaxesShirts);
  System.out.println("Total Cost of Belts: $" + totalCostOfBelts + ",Total sales taxes for belts: $" + salesTaxesBelts);
 //display the total cost of the purchases (before tax), the total sales tax, and the total cost of the purchases (including sales tax). 
    
  System.out.println("Total Cost of all Items (Before Tax): $" + totalCost);
  System.out.println("Total Sales Taxes: $" + totalTaxes);
  System.out.println("Total Cost of the Purchase(With Taxes): $" + totalPaid);


    
  }
}