import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int MAX_HEIGHT;
    private int MAX_WIDTH;

    private List<Coordinates> obstacles = new ArrayList<>();

    public List<Coordinates> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

    public void addObstacles(Coordinates obstacle){
        obstacles.add(obstacle);
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    public void setMAX_HEIGHT(int MAX_HEIGHT) {
        this.MAX_HEIGHT = MAX_HEIGHT;
    }

    public int getMAX_WIDTH() {
        return MAX_WIDTH;
    }

    public void setMAX_WIDTH(int MAX_WIDTH) {
        this.MAX_WIDTH = MAX_WIDTH;
    }

    public Grid(int MAX_HEIGHT, int MAX_WIDTH, List<Coordinates> obstacles) {
        this.MAX_HEIGHT = MAX_HEIGHT;
        this.MAX_WIDTH = MAX_WIDTH;
        this.obstacles = obstacles;
    }
}
