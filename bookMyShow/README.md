# BookMyShow - LLD

Movie ticket reservation system handling seat holds, concurrent booking, and dynamic pricing.

## Core classes

- `Film` - movie details (id, name, language)
- `Cinema` - theater venue containing multiple halls
- `Hall` - single auditorium inside a cinema
- `Chair` - physical seat with row/col and tier info
- `ScreeningChair` - a chair's state for a particular screening (free/held/reserved)
- `Screening` - one show of a film in a specific hall at a given time
- `Customer` - the person booking
- `Reservation` - a booking record with status and price
- `HoldManager` - handles temporary TTL-based holds on chairs to prevent double booking
- `ReservationService` - orchestrates the booking flow (hold -> pay -> confirm)
- `PriceCalculator` / `DemandBasedPricing` - strategy interface + demand-surge implementation

## Design highlights

- **Concurrency**: `HoldManager` uses `synchronized` to atomically check + lock chairs, so two users can't grab the same seat.
- **TTL holds**: chairs are held with an expiry timestamp. If payment doesn't happen in time the hold lapses and the chair goes back to free.
- **Strategy pattern** for pricing, so surge/discount rules can be swapped without touching the service.
- **Cancel support**: `dropReservation` handles both pending and confirmed states (fixed from original which only handled confirmed).

## Run

```
javac *.java
java Main
```
