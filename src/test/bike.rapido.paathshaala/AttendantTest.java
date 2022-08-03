import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AttendantTest {
    Attendant attendant;
    Integer capacity;
    Integer slots;
    @Before
    public void setUp() throws Exception {
        capacity = 2;
        slots=1;
        attendant = new Attendant(capacity,slots);

    }

    @Test
    public void shouldParkWhenThereIsASlotAvailable() {
        boolean actualValue = attendant.park();
        assertTrue(actualValue);
    }

    @Test
    public void unpark() {
        boolean val = attendant.park();

        boolean actualValue = attendant.unpark();

        assertTrue(actualValue);



    }
}
