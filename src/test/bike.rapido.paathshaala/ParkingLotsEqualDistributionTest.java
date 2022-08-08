import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ParkingLotsEqualDistributionTest {
    Attendant attendant;
    @Before
    public void setUp()  {
        attendant = new Attendant(3,3);

    }
    @Test
    public void shouldParkThreeCarsInThreeDifferentConsecutiveParkingLots() {
        attendant.setStrategy(new EvenDistributionOfParkingVehicle());
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Optional<ParkingLot> parkingLotNumberForCar1 = attendant.park(car1);
        Optional<ParkingLot> parkingLotNumberForCar2 = attendant.park(car2);
        Optional<ParkingLot> parkingLotNumberForCar3 = attendant.park(car3);

        assertEquals(0, parkingLotNumberForCar1.get().getId());
        assertEquals(1, parkingLotNumberForCar2.get().getId());
        assertEquals(2, parkingLotNumberForCar3.get().getId());

    }

    @Test
    public void shouldParkCar2AtParkingLotNumberOneAfterUnParking() {
        attendant.setStrategy(new EvenDistributionOfParkingVehicle());
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        attendant.unPark(car2);
        Optional<ParkingLot> parkingLotNumberForCar4 = attendant.park(car4);

        assertEquals(1,parkingLotNumberForCar4.get().getId());


    }
    @Test
    public void shouldParkCar7AndCar8AtParkingLotNumberTwo(){
        attendant.setStrategy(new EvenDistributionOfParkingVehicle());
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();

        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        attendant.park(car4);
        attendant.park(car5);
        attendant.park(car6);
        attendant.unPark(car3);
        attendant.unPark(car6);

        Optional<ParkingLot> parkingLotNumberForCar7 = attendant.park(car7);
        Optional<ParkingLot> parkingLotNumberForCar8 = attendant.park(car8);
        assertEquals(2,parkingLotNumberForCar7.get().getId());
        assertEquals(2,parkingLotNumberForCar8.get().getId());

    }


}
