import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class FirstFreeAvailableTest {
    Attendant attendant;

    @Before
    public void setUp()  {
        attendant = new Attendant(2,3);
        attendant.setStrategy(new FirstFreeAvailable());
    }
    @Test
    public void shouldParkCarWhenFirstFreeSlotAvailableUntilFilledUp() {

        Car car1 = new Car();
        Car car2 = new Car();

        Optional<ParkingLot> parkingLotNumberForCar1 = attendant.park(car1);
        Optional<ParkingLot> parkingLotNumberForCar2 = attendant.park(car2);

        assertEquals(0,parkingLotNumberForCar1.get().getId());
        assertEquals(0,parkingLotNumberForCar2.get().getId());


    }

    @Test
    public void shouldParkInFirstSlotIfFirstLotBecomesAgainAvailable(){
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();

        Optional<ParkingLot> parkingLotNumberForCar1 = attendant.park(car1);
        Optional<ParkingLot> parkingLotNumberForCar2 = attendant.park(car2);
        Optional<ParkingLot> parkingLotNumberForCar3 = attendant.park(car3);
        attendant.unPark(car1);
        Optional<ParkingLot> parkingLotNumberForCar4 = attendant.park(car4);

        assertEquals(1,parkingLotNumberForCar3.get().getId());
        assertEquals(0,parkingLotNumberForCar4.get().getId());



    }
}
