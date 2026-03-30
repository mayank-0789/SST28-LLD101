# Elevator System - LLD

Multi-lift system design in Java covering dispatch, weight limits, and emergency handling.

## Core classes

- `Lift` - represents one physical elevator car (floor tracking, load, doors, movement)
- `LiftManager` - central dispatcher that routes all requests from panels
- `DispatchPolicy` - interface for pluggable lift-selection algorithms
- `NearestLiftPolicy` - picks the closest eligible lift (considers direction)
- `CabinControls` - buttons inside the lift (floor select, door open/close, alarm)
- `FloorButtons` - up/down call buttons on each floor
- `LiftStatus` / `Travel` - enums for lift state and travel direction

## Design decisions

- **Strategy pattern** for dispatch so different algorithms can be swapped without changing the manager.
- **Mediator-style controller** - both cabin and floor panels route through `LiftManager` to keep state management in one place.
- `synchronized` on manager methods to handle concurrent button presses safely.
- Movement is simulated synchronously (no real-time threading) to keep the LLD focused on structure rather than concurrency plumbing.

## Run

```
javac *.java
java Main
```
