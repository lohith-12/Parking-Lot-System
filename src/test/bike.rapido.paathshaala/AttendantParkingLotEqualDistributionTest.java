import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AttendantParkingLotEqualDistributionTest {
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

        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);
        attendant.unPark(car2);
        ParkFunctionReturnType parkingLotNumberForCar4 = attendant.park(car2);

        assertThat(parkingLotNumberForCar4.getLotNumber(),is(1));

    }
}
