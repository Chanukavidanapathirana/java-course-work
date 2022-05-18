import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    //making arrays for cabins and for the passengers.
    private static void initialise(int[] cabinno,String[] name){
        System.out.println("---Cabin reservation system---");
        for(int i=0; i<12;i++) {
            cabinno[i] = i + 1;
            name[i]="Empty";
        } for(int i=0;i<12;i++){
            if(name[i].equals("Empty")) {
                System.out.println("Cabin " + cabinno[i] + " is " + name[i]);
            }

            /*else{
                System.out.println("Room " + cabinno[i]+ " is owned by "+name[i]);
            }*/
        }
    }
    //Method to view all cabins.
    private static void View(int[] cabinno,String[] name){
        System.out.println("-----Details about all rooms-----\n");
        for (int i = 0; i < 12; i++) {
            if (name[i].equals("Empty")) {
                System.out.println("Cabin " + cabinno[i] + " is " + name[i]);
            } else {
                System.out.println("Cabin " + cabinno[i] + " is owned by " + name[i]);
            }
        }

    }
    //Method to display all empty cabins.
    public static void viewEmptyCabins(int[] cabinno,String[] name){
        System.out.println("-----Empty rooms-----\n");
        for (int i = 0; i < 12; i++) {
            if (name[i].equals("Empty")) {
                System.out.println("Cabin " + cabinno[i] + " is " + name[i]);
            }
        }

    }
    //method to delete customer from cabin.
    public static void deleteCustomer(String[] name){
        Scanner delcus= new Scanner(System.in);
        System.out.println("Enter the cabin number to delete the customer: ");
        int roomNumber=delcus.nextInt();
        name[roomNumber-1]="Empty";
        System.out.println("Customer deleted successfully");

    }public static void Add(String[] name ){
        while(true) {
            Scanner adding = new Scanner (System.in);
            System.out.println("Please enter the cabin no(1-12) : ");
            int cabinNo = adding.nextInt();
            if (cabinNo > 13 || cabinNo < 1) {//for end the loop
                System.out.println("Please enter a valid input");//if the user input a wrong number
                continue;


            } else if  (cabinNo <= 12 && cabinNo >= 1) {
                System.out.println("Please enter the customer name: ");
                String cusName = adding.next();


                name[cabinNo - 1] = cusName;
                System.out.println();
                break;
            } else {
                System.out.println("Please enter a valid input");
                continue;

            }

        }

    }
    public static  void findCabinNo(String[] names){

        Scanner findno = new Scanner(System.in);
        System.out.println("Enter the customer name: ");
        String cusname = findno.next();
        for(int i=0;i<names.length;i++){
            if(names[i].equals(cusname)){
                System.out.println( cusname +" is in cabin Number "+ (i+1));

            }
        }

    }
    //store information to the file
    public static void storeData(String[] name) {
        try {
            FileWriter writer = new FileWriter("Cabin Details.txt");
            for (String str : name) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
            System.out.println("Successfully wrote to the file. ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void loadData(File filename,String[] name){
        try{
            int i = 0;
            Scanner myReader = new Scanner(filename);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
                name[i] = data;
                i++;
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //view passengers ordered alphabetically by name
    public static void passengerSort(String[] name){
        //counting the new array(sort) length
        int arraylength = 0;
        for(int i =0;i<name.length;i++){
            if(name[i].equals("Empty")){

            }else{
                arraylength++;
            }

        }
        String[] sort = new String[arraylength];
        //creating array(sort) only with names
        int count=0;//using count to create sort array
        for(int i =0;i<name.length;i++){
            if(name[i].equals("Empty")){

            }else{
             sort[count]= name[i];
             count++;
            }

        }
        //sorting starting
        int n = sort.length;
        for (int i =0 ; i<n-1 ; i++){
            for (int j = 0 ; j<=n-2 ; j++){
                if((sort[j]).compareTo(sort [j+1])>0){
                    // swap arr[j+1] and arr[j]
                    String temp =sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1] =temp;

                }
            }

        }


        System.out.println(Arrays.toString(sort));

    }
  



    public static void main(String[] args) throws IOException {

        int[] cabinNumber = new int[12];
        String[] passangerName = new String[12];
        initialise(cabinNumber, passangerName);
        //Scanner input = new Scanner(System.in);
        //creating a file to store information about cabins
        File cabinFile = null;
        try {
            cabinFile = new File("Cabin Details.txt");
            if (cabinFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


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
            System.out.println("Enter 'Q' to quite from the program");
            System.out.println("Enter  your input :- ");
            Scanner userinput = new Scanner(System.in);
                String input = userinput.next();
                input.toUpperCase();
                if(!(input.equals("A")||input.equals("V") ||input.equals("E")||input.equals("D")||input.equals("F")||input.equals("S")||input.equals("L")||input.equals("O")||input.equals("Q"))){
                    System.out.println("***Please enter a valid input***");
                    continue;
                }else{
                    switch (input){
                        case "A":
                            Add(passangerName);
                            break;
                        case "V":
                            View(cabinNumber,passangerName);
                            break;
                        case "E":
                            viewEmptyCabins(cabinNumber,passangerName);
                            break;
                        case "D":
                            deleteCustomer(passangerName);
                            break;
                        case "F":
                            findCabinNo(passangerName);
                            break;
                        case "S":
                            storeData(passangerName);
                            break;
                        case "L":
                            loadData(cabinFile,passangerName);
                            break;
                        case "O":
                            passengerSort(passangerName);
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
}
