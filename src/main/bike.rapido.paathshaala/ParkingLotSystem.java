import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args){
        Integer capacity = 2;

        Integer  numberOfLots=2;


        Attendant attendant = new Attendant(capacity,numberOfLots);
        Car car = new Car();
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

            String successMessage;
            switch (choice) {
                case 1:
                    //car = new Car();
                    int index = attendant.park(car);
                    System.out.println(CONSTANTS.SLOT_IS_ALLOCATED_SUCCESSFULLY+index);
                    System.out.println();
                    break;
                case 2:
                    //car = new Car();
                    attendant.unPark(car);
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