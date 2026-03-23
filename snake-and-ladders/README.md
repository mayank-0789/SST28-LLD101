# Snake and Ladders

Simple Snake and Ladders game in Java using the Strategy pattern for different game modes.

## Design

* **Strategy Pattern:** Turn logic is behind a `MoveStrategy` interface. `NormalMoveStrategy` gives an extra roll on 6. `StrictMoveStrategy` adds a rule where three 6s in a row cancels your turn. Switching modes doesn't touch the `Game` class.
* **Factory Pattern:** `GameFactory` takes player names, board config, and mode string, and sets up the whole game. Keeps `Main` clean.
* **Domain Entities:** `Snake`, `Ladder`, `Player`, `Dice`, and `Board` each handle one thing. `Board` checks if a position has a snake or ladder, `Game` runs the turn queue.

## How to Run

```bash
javac *.java
java Main
```
