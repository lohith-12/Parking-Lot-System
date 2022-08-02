import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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