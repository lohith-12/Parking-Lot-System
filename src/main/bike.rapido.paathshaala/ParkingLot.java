import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args){
        Integer capacity = 2;

        ParkingSlotAllocationSystem [] Lots= new ParkingSlotAllocationSystem[2];

        Attendant attendant = new Attendant(capacity,Lots);

        int choice;
        do {
            System.out.println("______________________________________________");
            System.out.println("| Welcome to the Parking Management System!   |");
            System.out.println("| Choose from the options :                   |");
            System.out.println("| 1. Park a car                               |");
            System.out.println("| 2. Remove a car                             |");
            System.out.println("| 3. Exit                                     |");
            System.out.println("_______________________________________________");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            boolean successMessage;
            switch (choice) {
                case 1:
                    successMessage = attendant.park();
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                case 2:
                    successMessage = attendant.unpark();
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Please ! Enter the valid options [1,2,3]");
                    System.out.println();
            }
        } while (choice != 3);



    }

}