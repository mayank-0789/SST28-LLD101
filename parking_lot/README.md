# Multi-Level Parking Lot

A simple parking lot system in Java that handles slot assignment and fee calculation using the Strategy pattern.

## Design

* **Strategy Pattern:** Slot assignment and fee calculation are both pluggable. `NearestSpotStrategy` finds the closest available spot using 3D Euclidean distance (floor difference is weighted). `HourlyFeeStrategy` charges per hour based on slot type. Both can be swapped out without touching `ParkingLot`.
* **Domain Entities:** `ParkingSpot`, `Gate`, `Vehicle`, and `ParkingTicket` each hold their own data. The `ParkingLot` class just wires things together.
* **Trade-offs:** Slot search is O(N) linear scan which works fine for this scale. A priority queue would be better for large lots. Thread safety is skipped to keep things simple.

## How to Run

```bash
javac parking_lot/*.java
java parking_lot.Main
```
