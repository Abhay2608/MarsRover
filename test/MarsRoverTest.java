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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH);
    }
    @Test
    public void testPositive(){
        assertEquals(true,true);
    }

    @Test
    public void createMarsRover(){
        assertThat(marsRover,is(new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH)));
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

    @Test
    @Parameters({
            "f, 0:4:N",
            "ff, 0:3:N",
            "fff, 0:2:N",
            "ffff, 0:1:N"
    })
    public void facingNorthMoveForward(String commands,String position){
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "f, 0:1:S",
            "ff, 0:2:S",
            "fff, 0:3:S",
            "ffff, 0:4:S"
    })
    public void facingSouthMoveForward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.SOUTH);
        assertThat(marsRover.execute(commands), is(position));
    }


    @Test
    @Parameters({
            "f, 1:0:E",
            "ff, 2:0:E",
            "fff, 3:0:E",
            "ffff, 4:0:E"
    })
    public void facingEastMoveForward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.EAST);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "f, 4:0:W",
            "ff, 3:0:W",
            "fff, 2:0:W",
            "ffff, 1:0:W"
    })
    public void facingWestMoveForward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.WEST);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "b, 0:1:N",
            "bb, 0:2:N",
            "bbb, 0:3:N",
            "bbbb, 0:4:N"
    })
    public void facingNorthMoveBackward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "b, 0:4:S",
            "bb, 0:3:S",
            "bbb, 0:2:S",
            "bbbb, 0:1:S"
    })
    public void facingSouthMoveBackward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.SOUTH);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "b, 4:0:E",
            "bb, 3:0:E",
            "bbb, 2:0:E",
            "bbbb, 1:0:E"
    })
    public void facingEastMoveBackward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.EAST);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "b, 1:0:W",
            "bb, 2:0:W",
            "bbb, 3:0:W",
            "bbbb, 4:0:W"
    })
    public void facingWestMoveBackward(String commands,String position){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.WEST);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "ffrffrffrf, 3:2:W",
            "bblffrffff, 0:0:N",
            "bblffrffffbbbbrffff, 4:4:E"
    })
    public void moveRandomRotateRandom(String commands,String position){
        marsRover = new MarsRover(new Coordinates(2,2), MarsRover.Direction.NORTH);
        assertThat(marsRover.execute(commands), is(position));
    }
}
