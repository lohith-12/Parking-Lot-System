import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ParkingLotsEqualDistributionTest {
    Attendant attendant;
    @Before
    public void setUp()  {
        attendant = new Attendant(3,3);
    }
    @Test
    public void shouldParkThreeCarsInThreeDifferentConsecutiveParkingLots() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        ParkFunctionReturnType parkingLotNumberForCar1 = attendant.park(car1);
        ParkFunctionReturnType parkingLotNumberForCar2 = attendant.park(car2);
        ParkFunctionReturnType parkingLotNumberForCar3 = attendant.park(car3);

        assertThat(parkingLotNumberForCar1.getLotNumber(),is(0));
        assertThat(parkingLotNumberForCar2.getLotNumber(),is(1));
        assertThat(parkingLotNumberForCar3.getLotNumber(),is(2));
    }

    @Test
    public void shouldParkCar2AtParkingLotNumberOneAfterUnParking() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        attendant.unPark(car2);
        ParkFunctionReturnType parkingLotNumberForCar4 = attendant.park(car4);

        assertThat(parkingLotNumberForCar4.getLotNumber(),is(1));

    }
    @Test
    public void shouldParkCar7AndCar8AtParkingLotNumberTwo(){
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

        ParkFunctionReturnType parkingLotNumberForCar7 = attendant.park(car7);
        ParkFunctionReturnType parkingLotNumberForCar8 = attendant.park(car8);
        assertThat(parkingLotNumberForCar7.getLotNumber(),is(2));
        assertThat(parkingLotNumberForCar8.getLotNumber(),is(2));

    }
}
