import java.util.Objects;

public class MarsRover {
    private int x;
    private int y;
    private Direction direction;
    private String commands;

    enum Direction{
        NORTH('N','W','E'),
        SOUTH('S','E','W'),
        EAST('E','N','S'),
        WEST('W','S','N');

        private final char value;
        private final char left;
        private final char right;

        Direction(char value, char left, char right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Direction right(){
            return matchDirection(right);
        }

        public Direction left(){
            return matchDirection(left);
        }

        private Direction matchDirection(char value){
            for(Direction d : values()){
                if(d.value == value){
                    return d;
                }
            }
            return null;
        }
    }

    public MarsRover(int x, int y, Direction direction) {
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

    public String execute(String commands){
        for(char c : commands.toCharArray()){
            if(c == 'r') {
                direction = direction.right();
            }
            else if(c == 'l') {
                direction = direction.left();
            }
        }
        StringBuilder currentPosition = new StringBuilder();
        currentPosition.append(this.x).append(":").append(this.y).append(":").append(this.direction.value);
        return currentPosition.toString();
    }
}
