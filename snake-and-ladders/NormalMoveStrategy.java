public class NormalMoveStrategy implements MoveStrategy {
    @Override
    public boolean playTurn(Player player, Board board, Dice dice) {
        boolean hasExtraTurn = true;

        while (hasExtraTurn) {
            int roll = dice.roll();
            System.out.println(player.getName() + " rolled a " + roll);

            if (roll == 6) {
                System.out.println("Rolled a 6! Extra turn.");
                hasExtraTurn = true;
            } else {
                hasExtraTurn = false;
            }

            int newPos = player.getPosition() + roll;

            if (newPos > board.getSize()) {
                continue;
            }

            newPos = board.evaluatePosition(newPos);
            player.setPosition(newPos);
            System.out.println(player.getName() + " moved to " + newPos);

            if (player.getPosition() == board.getSize()) {
                return true;
            }
        }
        return false;
    }
}
