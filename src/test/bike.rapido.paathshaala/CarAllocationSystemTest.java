import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarAllocationSystemTest {
    CarAllocationSystem carAllocationSystem;

    @Before
    public void setUp() throws Exception {
        carAllocationSystem = new CarAllocationSystem();
    }

    @Test
    public void shouldAllocateSpaceForOneCar(){
        String actualMessage = carAllocationSystem.allocateSpace();
        String expectedMessage = "Your car parked successfully.";

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldAllocateSpaceForTwoCars(){
        carAllocationSystem.allocateSpace();

        String actualMessage = carAllocationSystem.allocateSpace();
        String expectedMessage = "Your car parked successfully.";

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotAllocateSpaceForCarAfterParkingSpaceIsFull(){
        carAllocationSystem.allocateSpace();
        carAllocationSystem.allocateSpace();

        String actualMessage = carAllocationSystem.allocateSpace();
        String expectedMessage = "Sorry! All slots are occupied.";

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldBeAbleToDeallocateSpace(){
        carAllocationSystem.allocateSpace();

        String actualMessage = carAllocationSystem.deallocateSpace();

        String expectedMessage = "Your car removed successfully.";

        assertThat(actualMessage, is(expectedMessage));
    }

    @Test
    public void shouldNotBeAbleToDeallocateSpaceIfNoCarIsParkedYet(){

        String expectedMessage = "Sorry, no car is parked yet.";

        String actualMessage = carAllocationSystem.deallocateSpace();

        assertThat(actualMessage, is(expectedMessage));
    }


}