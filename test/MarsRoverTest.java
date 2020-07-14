import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void testPositive(){
        assertEquals(true,true);
    }

    @Test
    public void createMarsRover(){
        MarsRover marsRover = new MarsRover(0,0,'N');
        assertThat(marsRover,is(new MarsRover(0,0,'N')));
    }
}
