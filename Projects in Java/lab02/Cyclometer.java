//Tariq Al-Serhan
// Sep 06 18
// Lab02
public class Cyclometer {
// main method required for every Java program
public static void main(String[] args) {

// Declare variables and intialize them

int secsTrip1 = 480;  // Time for trip1
int secsTrip2 = 3220;  //Time for trip2
int countsTrip1 = 1561;  //
int countsTrip2 = 9037; //
double wheelDiameter = 27.0,  //Diameter of the wheel
PI = 3.14159, // intiialize pi 
feetPerMile = 5280,  //how many feet in a mile
inchesPerFoot = 12,   //how many inches in a foot
secondsPerMinute = 60;  //how many seconds in a minute
double distanceTrip1, distanceTrip2,totalDistance;  //initialize distance variables
System.out.println("Trip 1 took "+ (secsTrip1/secondsPerMinute)+" minutes and had " + countsTrip1+" counts.");//print the statement for time of trip 1
System.out.println("Trip 2 took "+ (secsTrip2/secondsPerMinute)+" minutes and had "+ countsTrip2+" counts.");//print the statement for time of trip 2
//Calculate the distance of trip 1
distanceTrip1 = countsTrip1 * wheelDiameter*PI;
// Above gives distance in inches
//(for each count, a rotation of the wheel travels
//the diameter in inches times PI)
distanceTrip1 /= inchesPerFoot * feetPerMile; // Gives distance in miles
distanceTrip2 = countsTrip2 * wheelDiameter * PI / inchesPerFoot / feetPerMile;
totalDistance = distanceTrip1 + distanceTrip2;
//Print out the output data.
System.out.println("Trip 1 was "+distanceTrip1+" miles");
System.out.println("Trip 2 was "+distanceTrip2+" miles");
System.out.println("The total distance was " + totalDistance + " miles");//print the total distance to the screen



}  //end of main method   
} //end of class
