import java.util.Objects;

class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Coordinates moveForward(Coordinates coordinates, MarsRover.Direction direction){
        int x = coordinates.getX();
        int y = coordinates.getY();
        if(direction == MarsRover.Direction.NORTH){
            if(y > 0){
                y = y-1;
            }
            else{
                y = (5-1);
            }
        }
        else if(direction == MarsRover.Direction.SOUTH){
            y = (y + 1) % 5;   //MAX_HEIGHT
        }
        else if(direction == MarsRover.Direction.EAST){
            x = (x + 1) % 5;   //MAX_WIDTH
        }
        else if(direction == MarsRover.Direction.WEST){
            if(x > 0){
                x = x-1;
            }
            else{
                x = (5 -1);
            }
        }
        return new Coordinates(x,y);
    }
}
