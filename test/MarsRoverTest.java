import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.CORBA.StringHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverTest {
    private MarsRover marsRover;
    private Grid grid;
    private List<Coordinates> obstacles;
    @Before
    public void beforeRoverTest(){
        obstacles = new ArrayList<>();
        grid = new Grid(5,5,obstacles);
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid);
    }
    @Test
    public void testPositive(){
        assertEquals(true,true);
    }

    @Test
    public void createMarsRover(){
        assertThat(marsRover,is(new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid)));
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.SOUTH,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.EAST,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.WEST,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.SOUTH,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.EAST,grid);
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
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.WEST,grid);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "ffrffrffrf, 3:2:W",
            "bblffrffff, 0:0:N",
            "bblffrffffbbbbrffff, 4:4:E"
    })
    public void moveRandomRotateRandom(String commands,String position){
        marsRover = new MarsRover(new Coordinates(2,2), MarsRover.Direction.NORTH,grid);
        assertThat(marsRover.execute(commands), is(position));
    }

    @Test
    @Parameters({
        "rrfflf , c:0:2:E - o:1:2:E",
            "rfffrfff , c:3:2:S - o:3:3:S"
    })
    public void stopAndReportObstacle(String commands, String result){
        grid = new Grid(5,5,obstacles);
        grid.addObstacles(new Coordinates(1,2));
        grid.addObstacles(new Coordinates(3,3));
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid);
        assertThat(marsRover.execute(commands), is(result));
    }

    @Test
    @Parameters({
            "ffff , 0:6:N",
            "lffff , 6:0:W",
            "rrb, 0:9:S",
            "rb , 9:0:E"
    })
    public void increaseGridHeightGridWidth(String commands, String position){
        grid = new Grid(10,10,obstacles);
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid);
        assertThat(marsRover.execute(commands),is(position));
    }

    @Test
    @Parameters({
            "rrfffrbbbrf, c:1:5:N - o:1:4:N",
            "ffffffrf, c:2:6:E - o:3:6:E"
    })
    public void increaseObstacles(String commands,String result){
        grid = new Grid(10,4,obstacles);
        grid.addObstacles(new Coordinates(1,4));
        grid.addObstacles(new Coordinates(3,6));
        marsRover = new MarsRover(new Coordinates(2,2), MarsRover.Direction.NORTH,grid);
        assertThat(marsRover.execute(commands),is(result));
    }

    @Test
    @Parameters({
            "xx, Illegal Command"
    })
    public void checkExceptionOnIllegalCommand(String commands,String result){
        marsRover = new MarsRover(new Coordinates(0,0), MarsRover.Direction.NORTH,grid);
        assertThat(marsRover.execute(commands),is(result));
    }
}
