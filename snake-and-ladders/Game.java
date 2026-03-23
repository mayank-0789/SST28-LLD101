import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> playerQueue;
    private Dice dice;
    private MoveStrategy moveStrategy;

    public Game(Board board, Queue<Player> playerQueue, Dice dice, MoveStrategy moveStrategy) {
        this.board = board;
        this.playerQueue = playerQueue;
        this.dice = dice;
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        while (!playerQueue.isEmpty()) {
            Player current = playerQueue.poll();

            boolean won = moveStrategy.playTurn(current, board, dice);

            if (won) {
                System.out.println(current.getName() + " wins the game!");
                return;
            }

            playerQueue.offer(current);
        }
    }
}
