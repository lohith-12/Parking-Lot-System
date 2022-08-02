import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args){
        Integer capacity = 2;
        Owner owner = new Owner();
        SecurityPersonal securityPersonal = new SecurityPersonal();
        ParkingSlotAllocationSystem parkingSlotAllocationSystem = new ParkingSlotAllocationSystem(capacity);

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

            String successMessage="";
            switch (choice) {
                case 1:
                    successMessage = parkingSlotAllocationSystem.allocateSpace();
                    System.out.println(successMessage);
                    System.out.println();
                    break;
                case 2:
                    successMessage =  parkingSlotAllocationSystem.deallocateSpace();
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