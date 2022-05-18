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
    public  void deletePassengersFromCabin(Queue queue,Cabin[] cabinRooms){
       if(cabinFullOrNot(cabinRooms)||queue.isEmpty()) {
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
       }else if(!(cabinFullOrNot(cabinRooms)) && !(queue.isEmpty())) {

           //deque
           passenger1.setFirstName(queue.deQueue().getFirstName());
           passenger1.setSurNameName(queue.deQueue().getSecondName());
           passenger1.setFullName(queue.deQueue().getFirstName(),queue.deQueue().getSecondName());
           passenger1.setCostPerCustomer(queue.deQueue().getCostPerCustomer());

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

           queue.updatingDequeue();
       }

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
    //checking whether cabins full or not
    public static boolean cabinFullOrNot(Cabin[] cabinRooms){
       boolean check = false;
       for(int i = 0; i<12; i++) {
          check = check || cabinRooms[i].passenger1.getSecondName().equals("e");
       }
       return check;
    }
    public static void addPassengers(Cabin[] cabinRooms,Queue queue){
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

            if(!(cabinFullOrNot(cabinRooms))){//check the cabins
                System.out.print("If you want to add another passenger to queue, press 'y'. If not, press any key:- ");
                String addQorNot = input.next();
                addQorNot = addQorNot.toUpperCase();

                if (queue.isFull()){
                    System.out.println("Queue is also filled.Sorry!");
                    break;
                }
                else if(addQorNot.equals("Y")) {
                    System.out.println("*Cabins full with passengers.We are going to add you to the queue.We will add you to a cabin when one of the passenger leave the cabin");
                    System.out.println("");
                    System.out.print("Passenger first name:- ");
                    passenger1Firstname = input.next();
                    System.out.print("Passenger surname:- ");
                    passenger1Surname = input.next();
                    System.out.print("Passenger cost:- ");
                    passenger1Cost = input.nextDouble();

                    queue.enQueue(passenger1Firstname, passenger1Surname, passenger1Cost);

                }else{
                    break;
                }
            }else {

                System.out.println("Enter cabin number (1-12) or 13 to stop:");

                roomNum = input.nextInt();
                //break the iteration
                if (roomNum == 13) {
                    break;
                } else if (roomNum >= 1 && roomNum < 13) {
                    System.out.println("****** Enter passengers names for room " + roomNum + "****** ");
                    //passenger 1 details
                    System.out.print("Passenger 1 first name :- ");
                    passenger1Firstname = input.next();
                    System.out.print("passenger 1 surname:- ");
                    passenger1Surname = input.next();
                    System.out.print("Enter the passenger 1 bill amount:-");
                    passenger1Cost = input.nextDouble();

                    //set customer1
                    cabinRooms[roomNum - 1].getCustomer1().setFirstName(passenger1Firstname);
                    cabinRooms[roomNum - 1].getCustomer1().setSurNameName(passenger1Surname);
                    cabinRooms[roomNum - 1].getCustomer1().setFullName(passenger1Firstname, passenger1Surname);
                    cabinRooms[roomNum - 1].getCustomer1().setCostPerCustomer(passenger1Cost);

                    //asking to add another passenger
                    System.out.print("If you want to add another passenger, press 'y'. If not, press any key(Passenger 2) :- ");
                    String addOrNot = input.next();
                    addOrNot = addOrNot.toUpperCase();
                    if(addOrNot.equals("Y")) {
                        //passenger 2 details
                        System.out.print("Passenger 2 first name :- ");
                        passenger2Firstname = input.next();
                        System.out.print("passenger 2 surname:- ");
                        passenger2Surname = input.next();
                        System.out.print("Enter the passenger 2 bill amount:-");
                        passenger2Cost = input.nextDouble();
                        //set customer2
                        cabinRooms[roomNum - 1].getCustomer2().setFirstName(passenger2Firstname);
                        cabinRooms[roomNum - 1].getCustomer2().setSurNameName(passenger2Surname);
                        cabinRooms[roomNum - 1].getCustomer2().setFullName(passenger2Firstname, passenger2Surname);
                        cabinRooms[roomNum - 1].getCustomer2().setCostPerCustomer(passenger2Cost);

                    }
                    System.out.print("If you want to add another passenger, press 'y'. If not, press any key(Passenger 3) :- ");
                    String addOrNot1 = input.next();
                    addOrNot1 = addOrNot1.toUpperCase();
                    if(addOrNot1.equals("Y")) {
                        //passenger 3 details
                        System.out.print("Passenger 3 first name :- ");
                        passenger3Firstname = input.next();
                        System.out.print("passenger 3 surname:- ");
                        passenger3Surname = input.next();
                        System.out.print("Enter the passenger 3 bill amount:-");
                        passenger3Cost = input.nextDouble();

                        //set customer3
                        cabinRooms[roomNum - 1].getCustomer3().setFirstName(passenger3Firstname);
                        cabinRooms[roomNum - 1].getCustomer3().setSurNameName(passenger3Surname);
                        cabinRooms[roomNum - 1].getCustomer3().setFullName(passenger3Firstname, passenger3Surname);
                        cabinRooms[roomNum - 1].getCustomer3().setCostPerCustomer(passenger3Cost);

                    }


                } else {
                    System.out.println("* * * * * Please enter a valid input * * * * * ");

                }
            }
        }
    }



}
