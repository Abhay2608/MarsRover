import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {
    private MarsRover marsRover;

    @Before
    public void beforeRoverTest(){
        marsRover = new MarsRover(0,0,'N');
    }
    @Test
    public void testPositive(){
        assertEquals(true,true);
    }

    @Test
    public void createMarsRover(){
        assertThat(marsRover,is(new MarsRover(0,0,'N')));
    }
}
