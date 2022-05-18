import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cabin {
    private Passenger passenger1 = new Passenger();
    private Passenger passenger2 = new Passenger();
    private Passenger passenger3 = new Passenger();
    private Passenger [] gustsInCabin = {passenger1,passenger2,passenger3};




    //Getters
   public Passenger getCustomer1(){
       return passenger1;
   }
   public Passenger getCustomer2(){return passenger2;}
   public Passenger getCustomer3(){
       return passenger3;
   }

   public Passenger getGustsInCabin(int i){return gustsInCabin[i];}



//Deleting
    public  void deletePassengersFromCabin(){
        //first Passenger
        passenger1.setFirstName("e");
        passenger1.setSurNameName("e");
        passenger1.setFullNameEmpty();
        passenger1.setCostPerCustomer(0);

        //second passenger
        passenger2.setFirstName("e");
        passenger2.setSurNameName("e");
        passenger2.setFullNameEmpty();
        passenger2.setCostPerCustomer(0);

        //third passenger
        passenger3.setFirstName("e");
        passenger3.setSurNameName("e");
        passenger3.setFullNameEmpty();
        passenger3.setCostPerCustomer(0);

    }
    public void viewAllCabins(int i){

            System.out.println("Cabin " + (i+1) + " occupied by " + getCustomer1().getFullName() + ", " + getCustomer2().getFullName() + ", " + getCustomer3().getFullName());


    }
    public void viewEmptyCabins(int i){
        if (getCustomer1().getFirstName().equals("e") && getCustomer2().getFirstName().equals("e") && getCustomer3().getFirstName().equals("e")){
            System.out.println("cabin " + (i+1) + " is empty");
        }

    }
    public void findCabin(String name,int i){

            for (int j = 0 ;j<3 ;j++) {
                if(getGustsInCabin(j).getFirstName().equals(name))
                    System.out.println(getGustsInCabin(j).getFirstName()+" is in cabin number " +(i+1));
            }

    }
    public static void addPassengers(Cabin[] cabinRooms){
        //creating strings for take names

        String passenger1Firstname;
        String passenger1Surname;
        double passenger1Cost;
        String passenger2Firstname;
        String passenger2Surname;
        double passenger2Cost;
        String passenger3Firstname;
        String passenger3Surname;
        double passenger3Cost;
        int roomNum = 0;

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Enter cabin number (1-12) or 13 to stop:");

            roomNum = input.nextInt();
            //break the iteration
            if(roomNum==13){
                break;
            }else if(roomNum>=1 && roomNum<13) {
                System.out.println("****** Enter passengers names for room " + roomNum + "****** ");
                //passenger 1 details
                System.out.print("Passenger 1 first name(Enter 'e' if there is no passenger) :- ");
                passenger1Firstname = input.next();
                System.out.print("passenger 1 surname(Enter 'e' if there is no passenger):- ");
                passenger1Surname = input.next();
                System.out.print("Enter the passenger 1 bill amount(Enter 0 if there is no passenger):-");
                passenger1Cost =input.nextDouble();

                //passenger 2 details
                System.out.print("Passenger 2 first name (Enter 'e' if there is no passenger):- ");
                passenger2Firstname = input.next();
                System.out.print("passenger 2 surname(Enter 'e' if there is no passenger):- ");
                passenger2Surname = input.next();
                System.out.print("Enter the passenger 2 bill amount(Enter 0 if there is no passenger):-");
                passenger2Cost =input.nextDouble();

                //passenger 3 details
                System.out.print("Passenger 3 first name(Enter 'e' if there is no passenger) :- ");
                passenger3Firstname = input.next();
                System.out.print("passenger 3 surname(Enter 'e' if there is no passenger):- ");
                passenger3Surname = input.next();
                System.out.print("Enter the passenger 3 bill amount(Enter 0 if there is no passenger):-");
                passenger3Cost =input.nextDouble();

                //set customer1
                cabinRooms[roomNum-1].getCustomer1().setFirstName(passenger1Firstname);
                cabinRooms[roomNum-1].getCustomer1().setSurNameName(passenger1Surname);
                cabinRooms[roomNum-1].getCustomer1().setFullName(passenger1Firstname,passenger1Surname);
                cabinRooms[roomNum-1].getCustomer1().setCostPerCustomer(passenger1Cost);

                //set customer2
                cabinRooms[roomNum-1].getCustomer2().setFirstName(passenger2Firstname);
                cabinRooms[roomNum-1].getCustomer2().setSurNameName(passenger2Surname);
                cabinRooms[roomNum-1].getCustomer2().setFullName(passenger2Firstname,passenger2Surname);
                cabinRooms[roomNum-1].getCustomer2().setCostPerCustomer(passenger2Cost);

                //set customer3
                cabinRooms[roomNum-1].getCustomer3().setFirstName(passenger3Firstname);
                cabinRooms[roomNum-1].getCustomer3().setSurNameName(passenger3Surname);
                cabinRooms[roomNum-1].getCustomer3().setFullName(passenger3Firstname,passenger3Surname);
                cabinRooms[roomNum-1].getCustomer3().setCostPerCustomer(passenger3Cost);





            }else{
                System.out.println("* * * * * Please enter a valid input * * * * * ");

            }
        }
    }
    //finding the cost per passenger and total cost of all passengers.
    public static void cost(Cabin cabinRooms[]){
        System.out.print("Enter the customer's first name to find the bill amount :-");
        Scanner inputForCost= new Scanner(System.in);
        String name = inputForCost.next();
        for(int i = 0; i<12 ;i++){
            for (int j = 0 ;j<3 ;j++) {
                if(cabinRooms[i].getGustsInCabin(j).getFirstName().equals(name))
                    System.out.println(cabinRooms[i].getGustsInCabin(j).getFirstName()+"(room no " +(i+1)+" )"+" cost is " +cabinRooms[i].getGustsInCabin(j).getCostPerCustomer());
            }
        }
        System.out.println("* if you didn't get the cost according to the customer first name, please reenter the correct first name * ");

        double fullTotal = 0;
        for(int i = 0; i<12 ;i++){
            for (int j = 0 ;j<3 ;j++) {
                fullTotal=fullTotal+ cabinRooms[i].getGustsInCabin(j).getCostPerCustomer();
            }
        }
        System.out.println("Total bill of all passengers:- "+ fullTotal);
    }

    public static void storeCabinDetails(Cabin[] cabinRooms){
        try {

            FileWriter myWriter = new FileWriter("CabinDetails.txt");
            for (int i = 0; i<12 ; i++) {
                myWriter.write( "Cabin number "+ (i+1) +System.lineSeparator());
                for(int j = 0; j<3 ; j++) {
                    myWriter.write(" passenger "+(j+1)+" :- { " + cabinRooms[i].getGustsInCabin(j).getFullName() + " - " +cabinRooms[i].getGustsInCabin(j).getCostPerCustomer()+" }"+ System.lineSeparator());
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void loadCabinDetails(){
        try {
            File myObj = new File("CabinDetails.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
