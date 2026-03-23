import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Snake> snakes = Arrays.asList(
            new Snake(27, 5),
            new Snake(40, 3),
            new Snake(62, 18),
            new Snake(90, 33)
        );

        List<Ladder> ladders = Arrays.asList(
            new Ladder(7, 29),
            new Ladder(15, 44),
            new Ladder(36, 58),
            new Ladder(71, 92)
        );

        List<String> playerNames = Arrays.asList("Alice", "Bob", "Charlie");

        Game game = GameFactory.createGame(playerNames, snakes, ladders, "NORMAL");
        game.play();
    }
}
