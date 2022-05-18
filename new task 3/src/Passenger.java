import java.util.Arrays;

public class Passenger {
       private String firstName;
       private String secondName;
       private String fullName = "empty" ;
       private double costPerCustomer = 0;
        //Getters
       public String getFirstName(){
           return firstName;
       }
       public String getSecondName(){
               return secondName;
       }
       public double getCostPerCustomer(){
           return costPerCustomer;
       }
       public String getFullName(){
           return fullName;
       }

       //Setters
       public void setFirstName(String fName){this.firstName = fName;}
        public void setSurNameName(String sName){this.secondName = sName;}
        public void setFullName (String sName, String fName){ this.fullName = sName + " "+ fName;}
        public void setFullNameEmpty(){this.fullName = "empty";}
        public void setCostPerCustomer(double amount){this.costPerCustomer = amount;}

    public static void sortNames(Cabin[] cabinrooms){
        int arraylength = 0;
        for(int i =0;i<cabinrooms.length;i++) {
            for (int j = 0; j < 3; j++){
                if (cabinrooms[i].getGustsInCabin(j).getFullName().equals("empty")||cabinrooms[i].getGustsInCabin(j).getSecondName().equals("e")) {

                } else {
                    arraylength++;
                }
            }
        }
        String[] sort = new String[arraylength];
        //creating array(sort) only with names
        int count=0;//using count to create sort array
        for(int i =0;i<cabinrooms.length;i++){
            for(int j = 0 ; j<3 ;j++) {
                if (cabinrooms[i].getGustsInCabin(j).getFullName().equals("empty")||cabinrooms[i].getGustsInCabin(j).getSecondName().equals("e")) {

                } else {
                    sort[count] = cabinrooms[i].getGustsInCabin(j).getFullName();
                    count++;
                }
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

        System.out.println("* * * Sorted Array of passenger names * * *");
        System.out.println(Arrays.toString(sort));

    }
}
