import com.sun.org.apache.xml.internal.security.utils.XalanXPathAPI;
import com.sun.scenario.effect.impl.state.RenderState;

import java.util.List;
import java.util.Objects;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private String commands;
    private Grid grid;

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

    public MarsRover(Coordinates coordinates, Direction direction, Grid grid) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.grid = grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(coordinates, marsRover.coordinates) &&
                direction == marsRover.direction &&
                Objects.equals(commands, marsRover.commands) &&
                Objects.equals(grid, marsRover.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction, commands, grid);
    }

    public String execute(String commands){
        for(char c : commands.toCharArray()){
            if(c == 'r') {
                direction = direction.right();
            }
            else if(c == 'l') {
                direction = direction.left();
            }
            else if(c == 'f'){
                Coordinates oldCoordinates = new Coordinates(coordinates.getX(), coordinates.getY());
                coordinates = coordinates.moveForward(coordinates,direction,grid.getMAX_HEIGHT(),grid.getMAX_WIDTH());
                if(isObstacle(coordinates,grid.getObstacles())){
                    StringBuilder currentPosition = new StringBuilder();
                    currentPosition.append("c").append(":").append(oldCoordinates.getX()).append(":").append(oldCoordinates.getY()).append(":").append(direction.value);
                    currentPosition.append(" - ").append("o").append(":").append(coordinates.getX()).append(":").append(coordinates.getY()).append(":").append(direction.value);
                    return currentPosition.toString();
                }
            }
            else if(c == 'b'){
                Coordinates oldCoordinates = new Coordinates(coordinates.getX(), coordinates.getY());
                coordinates = coordinates.moveBackward(coordinates,direction,grid.getMAX_HEIGHT(),grid.getMAX_WIDTH());
                if(isObstacle(coordinates,grid.getObstacles())){
                    StringBuilder currentPosition = new StringBuilder();
                    currentPosition.append("c").append(":").append(oldCoordinates.getX()).append(":").append(oldCoordinates.getY()).append(":").append(direction.value);
                    currentPosition.append(" - ").append("o").append(":").append(coordinates.getX()).append(":").append(coordinates.getY()).append(":").append(direction.value);
                    return currentPosition.toString();
                }
            }
        }
        StringBuilder currentPosition = new StringBuilder();
        currentPosition.append(coordinates.getX()).append(":").append(coordinates.getY()).append(":").append(this.direction.value);
        return currentPosition.toString();
    }

    public boolean isObstacle(Coordinates coordinates, List<Coordinates> obstacles){
        for(Coordinates obstacle : obstacles){
            if(obstacle.getX() == coordinates.getX() && obstacle.getY() == coordinates.getY())  return true;
        }
        return false;
    }
}
