# Pen System Design

A simple pen system in Java where different pen types (ballpoint, gel, fountain, marker) are built using the Strategy and Factory patterns.

## Architecture

* **Strategy Pattern:** Writing, refilling, and opening/closing are separate interfaces. Each pen type uses a different combination of these. Adding a new pen type doesn't require changing the `Pen` class at all.
* **Factory Pattern:** `PenFactory` wires up the right strategies based on the pen type and mechanism. The caller just says what kind of pen they want.
* **State Check:** The pen tracks if it's open or closed. Trying to write without opening it throws an exception.

## How to Run

```bash
javac pen/*.java
java pen.Main
```
