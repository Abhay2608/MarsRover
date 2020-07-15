import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverTest {
    private MarsRover marsRover;

    @Before
    public void beforeRoverTest(){
        marsRover = new MarsRover(0,0, MarsRover.Direction.NORTH);
    }
    @Test
    public void testPositive(){
        assertEquals(true,true);
    }

    @Test
    public void createMarsRover(){
        assertThat(marsRover,is(new MarsRover(0,0, MarsRover.Direction.NORTH)));
    }

    @Test
    @Parameters({
            "r, 0:0:E",
            "rr, 0:0:S",
            "rrr, 0:0:W",
            "rrrr, 0:0:N"
    })
    public void rotateRight(String commands,String position){
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "l, 0:0:W",
            "ll, 0:0:S",
            "lll, 0:0:E",
            "llll, 0:0:N"
    })
    public void rotateLeft(String commands,String position){
        assertThat(marsRover.execute(commands), is(position));
    }
}
