import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ParkingSlotAllocationSystemTest {
    ParkingSlotAllocationSystem parkingSlotAllocationSystem;
    Owner owner;
    SecurityPersonal securityPersonal;
    @Before
    public void setUp() throws Exception {
        owner = new Owner();
        securityPersonal = new SecurityPersonal();
        parkingSlotAllocationSystem = new ParkingSlotAllocationSystem(2);
    }

    @Test
    public void shouldAllocateSpaceForOneCar(){
        String actualMessage = parkingSlotAllocationSystem.allocateSpace();
        String expectedMessage = Messages.SLOT_IS_ALLOCATED_SUCCESSFULLY;

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSpaceForTwoCars(){
        parkingSlotAllocationSystem.allocateSpace();

        String actualMessage = parkingSlotAllocationSystem.allocateSpace();
        String expectedMessage = Messages.SLOT_IS_ALLOCATED_SUCCESSFULLY;

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotAllocateSpaceForCarAfterParkingSpaceIsFull(){
        parkingSlotAllocationSystem.allocateSpace();
        parkingSlotAllocationSystem.allocateSpace();
        String actualMessage = parkingSlotAllocationSystem.allocateSpace();
        String expectedMessage = Messages.ALL_SLOTS_ARE_OCCUPIED;
        assertThat(actualMessage, is(expectedMessage));

    }
    @Test
    public void shouldVerifyThatLotObserversIsNotifiedThatLotIsFull(){
        parkingSlotAllocationSystem.allocateSpace();
        parkingSlotAllocationSystem.allocateSpace();
        ParkingSlotAllocationSystem parkingSlotAllocationSystemspy = Mockito.spy(parkingSlotAllocationSystem);
        parkingSlotAllocationSystemspy.allocateSpace();
        verify(parkingSlotAllocationSystemspy,times(1)).notifyLotObserversThatSlotIsFull();
    }
    @Test
    public void shouldVerifyThatLotObserversIsNotifiedThatLotHasSlotsAgain(){
        parkingSlotAllocationSystem.allocateSpace();
        parkingSlotAllocationSystem.allocateSpace();
        ParkingSlotAllocationSystem parkingSlotAllocationSystemspy = Mockito.spy(parkingSlotAllocationSystem);
        parkingSlotAllocationSystemspy.deallocateSpace();
        verify(parkingSlotAllocationSystemspy,times(1)).notifyLotObserversThatSlotHasSpaceAgain();

    }

    @Test
    public void shouldBeAbleToDeallocateSpace(){
        parkingSlotAllocationSystem.allocateSpace();

        String actualMessage = parkingSlotAllocationSystem.deallocateSpace();

        String expectedMessage = Messages.SLOT_REMOVED_SUCCESSFULLY;

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotBeAbleToDeallocateSpaceIfNoCarIsParkedYet(){

        String expectedMessage = Messages.NO_SLOT_ALLOCATED_YET;

        String actualMessage = parkingSlotAllocationSystem.deallocateSpace();

        assertThat(actualMessage, is(expectedMessage));
    }


}