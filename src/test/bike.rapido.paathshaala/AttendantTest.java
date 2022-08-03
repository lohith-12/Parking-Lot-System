import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AttendantTest {
    Attendant attendant;
    Integer capacity;
    ParkingSlotAllocationSystem [] Lots;
    @Before
    public void setUp() throws Exception {
        capacity = 2;
        Lots= new ParkingSlotAllocationSystem[capacity];
        attendant = new Attendant(capacity,Lots);

    }

    @Test
    public void shouldParkWhenThereIsASlotAvailable() {
        boolean actualValue = attendant.park();
        assertTrue(actualValue);
    }

}
