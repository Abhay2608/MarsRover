import java.util.Objects;

public class MarsRover {
    private int x;
    private int y;
    private char direction;
    private String commands;


    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return x == marsRover.x &&
                y == marsRover.y &&
                direction == marsRover.direction &&
                Objects.equals(commands, marsRover.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction, commands);
    }
}
