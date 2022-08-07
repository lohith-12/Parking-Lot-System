import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;

public class AttendantTest {
    Attendant attendant;
    Integer capacity;
    Integer numberOfLots;
    @Before
    public void setUp() {
        capacity = 1;
        numberOfLots =2;
        attendant = new Attendant(capacity, numberOfLots);

    }

    @Test
    public void shouldParkWhenThereIsASlotAvailable() {
        Car car =new Car();

        ParkFunctionReturnType parkFunctionReturnType =  attendant.park(car);

        assertTrue(parkFunctionReturnType.getIsParked());

    }
    @Test
    public void shouldNotParkIfCarIsAlreadyParked() {
        Car car =new Car();
        attendant.park(car);

        ParkFunctionReturnType parkFunctionReturnType =  attendant.park(car);

        assertFalse(parkFunctionReturnType.getIsParked());
    }

    @Test
    public void shouldUnParkIfCarIsParked() {
        Car car =new Car();
        attendant.park(car);

        boolean isCarUnParked = attendant.unPark(car);

        assertTrue(isCarUnParked);
    }
    @Test
    public void shouldNotBeAbleToUnParkBeforeParking(){
        Car car = new Car();

        boolean actualValue = attendant.unPark(car);

        assertFalse(actualValue);
    }
    @Test
    public void shouldNotParkWhenParkingLotsAreFull(){
        Car car1 =new Car();
        Car car2 =new Car();
        Car car3 =new Car();
        attendant.park(car1);
        attendant.park(car2);

        ParkFunctionReturnType parkFunctionReturnType = attendant.park(car3);

        assertFalse(parkFunctionReturnType.getIsParked());
    }
    @Test
    public void shouldNotifyObserversThatFirstLotIsFull() {
        Attendant attendantSpy = Mockito.spy(new Attendant(1,2));
        Car car1 =new Car();

        attendantSpy.park(car1);

        Mockito.verify(attendantSpy).notifyLotObserversThatSlotIsFull(0);

    }
    @Test
    public void shouldNotNotifyObserversThatSecondLotIsNotFull() {
        Attendant attendantSpy = Mockito.spy(new Attendant(2,2));
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        attendantSpy.park(car1);
        attendantSpy.park(car2);
        attendantSpy.park(car3);

        Mockito.verify(attendantSpy,times(1)).notifyLotObserversThatSlotIsFull(0);
        Mockito.verify(attendantSpy,Mockito.never()).notifyLotObserversThatSlotIsFull(1);
    }
    @Test
    public void shouldNotifyObserversThatFirstLotHasFreeSpaceAgain() {
        Attendant attendantSpy = Mockito.spy(new Attendant(2,2));
        Car car1 =new Car();
        Car car2 =new Car();
        Car car3 =new Car();

        attendantSpy.park(car1);
        attendantSpy.park(car2);
        attendantSpy.park(car3);
        attendantSpy.unPark(car1);

        Mockito.verify(attendantSpy).notifyLotObserversThatSlotHasSpaceAgain(0);

    }
    @Test
    public void shouldBeAbleNotifyObserversThatFirstAndSecondLotsAreFull() {
        Attendant attendantSpy = Mockito.spy(new Attendant(1,2));
        InOrder inOrder = inOrder(attendantSpy);
        Car car1 =new Car();
        Car car2 = new Car();

        attendantSpy.park(car1);
        attendantSpy.park(car2);

        inOrder.verify(attendantSpy).notifyLotObserversThatSlotIsFull(0);
        inOrder.verify(attendantSpy).notifyLotObserversThatSlotIsFull(1);
    }

}
