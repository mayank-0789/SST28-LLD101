import java.util.List;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() { return size; }

    public int evaluatePosition(int position) {
        for (Snake snake : snakes) {
            if (snake.getHead() == position) {
                return snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getBottom() == position) {
                return ladder.getTop();
            }
        }

        return position;
    }
}
