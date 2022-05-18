import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    //initialize
    public static void main(String[] args) {

        //Cabin array objects
        Cabin[] cabinRooms = new Cabin[12];
        //creating file
        try {
            File cabinDetails = new File("CabinDetails.txt");
            if (cabinDetails.createNewFile()) {
                System.out.println("File created: " + cabinDetails.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        initialise(cabinRooms);
        //




        //Menu list

        while(true){
            System.out.println();
            System.out.println(" = = = = = Menu = = = = = ");

            System.out.println("Enter 'A' to add customer to the cabin");
            System.out.println("Enter 'V' to view all cabins");
            System.out.println("Enter 'E' to view empty cabins");
            System.out.println("Enter 'D' to delete a customer from cabin");
            System.out.println("Enter 'F' to find cabin from customer name");
            System.out.println("Enter 'S' to store program data into file ");
            System.out.println("Enter 'L' to load program data from file");
            System.out.println("Enter 'O' to  view passengers alphabetically ordered list");
            System.out.println("Enter 'T' to get expenses for a passenger and all the passengers total cost");
            System.out.println("Enter 'Q' to quite from the program");

            System.out.println("Enter  your input :- ");
            Scanner userinput = new Scanner(System.in);
            String input = userinput.next();
            input = input.toUpperCase();
            // restart the while loop when entered a wrong input.
            if(!(input.equals("A")||input.equals("V") ||input.equals("E")||input.equals("D")||input.equals("F")||input.equals("S")||input.equals("L")||input.equals("O")||input.equals("Q")||input.equals("T"))){
                System.out.println("***Please enter a valid input***");
                continue;
            }else{
                switch (input){
                    case "A":
                        Cabin.addPassengers(cabinRooms);
                        break;
                    case "V":
                        for (int i =0 ; i<12 ; i++){
                            cabinRooms[i].viewAllCabins(i);
                        }

                        break;
                    case "E":
                        for(int i = 0 ; i<12 ;i++) {
                            cabinRooms[i].viewEmptyCabins(i);
                        }
                        break;
                    case "D":
                        System.out.println("Enter the cabin number to delete the passengers :- ");
                        Scanner input1 = new Scanner(System.in);
                        int i = input1.nextInt();
                        cabinRooms[i-1].deletePassengersFromCabin();
                        break;
                    case "F":
                        Scanner inputfind = new Scanner(System.in);
                        System.out.print("Enter passenger first name to find the cabin :- ");
                        String name = inputfind.next();

                        for(int l =0 ; l<12 ;l++){

                            cabinRooms[l].findCabin(name,l);}
                        break;
                    case "S":
                        Cabin.storeCabinDetails(cabinRooms);
                        break;
                    case "L":
                        Cabin.loadCabinDetails();
                        break;
                    case "O":
                        Passenger.sortNames(cabinRooms);
                        break;
                    case "T":
                        Cabin.cost(cabinRooms);
                        break;
                    case "Q":
                        break;
                }
                if(input.equals("Q")){
                    break;
                }
            }

        }




    }

    private static void initialise(Cabin cabinrooms[]) {
        for(int i =0; i < 12; i++  ){
            cabinrooms[i] = new Cabin();
        }

        for (int x = 0; x < 12; x++){
            //assigning first name
            cabinrooms[x].getCustomer1().setFirstName("e");
            cabinrooms[x].getCustomer2().setFirstName("e");
            cabinrooms[x].getCustomer3().setFirstName("e");
            //assigning second name
            cabinrooms[x].getCustomer1().setSurNameName("e");
            cabinrooms[x].getCustomer2().setSurNameName("e");
            cabinrooms[x].getCustomer3().setSurNameName("e");

        }

        System.out.println("initilise ");
    }





    }
//}




