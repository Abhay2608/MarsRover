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

    public String execute(String commands){
        for(char c : commands.toCharArray()){
            if(c == 'r')    this.direction = rotateRight();
            else if(c == 'l')   this.direction = rotateLeft();
        }
        StringBuilder currentPosition = new StringBuilder();
        currentPosition.append(this.x).append(":").append(this.y).append(":").append(this.direction);
        return currentPosition.toString();
    }

    public char rotateRight(){
        switch (this.direction){
            case 'N': this.direction = 'E';
                      break;
            case 'E': this.direction = 'S';
                      break;
            case 'S': this.direction = 'W';
                      break;
            case 'W': this.direction = 'N';
                      break;
        }
        return this.direction;
    }

    public char rotateLeft(){
        switch (this.direction){
            case 'N': this.direction = 'W';
                break;
            case 'W': this.direction = 'S';
                break;
            case 'S': this.direction = 'E';
                break;
            case 'E': this.direction = 'N';
                break;
        }
        return this.direction;
    }
}
