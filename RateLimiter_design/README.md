# Rate Limiter - LLD

Controls how many requests a client can make to a resource within a time window.

## Core classes

- `Throttle` - interface representing a rate-limited resource
- `ThrottlePolicy` - strategy interface for the throttling algorithm
- `FixedBucketPolicy` - fixed window: resets counter every N milliseconds
- `RollingWindowPolicy` - sliding window: tracks individual request timestamps
- `ApiEndpoint` - the actual backend resource being protected
- `ThrottledEndpoint` - proxy that wraps the endpoint with a throttle policy

## Design

- **Strategy pattern** for the throttle rule so you can swap fixed-window / sliding-window / token-bucket without touching the proxy.
- **Proxy pattern** — `ThrottledEndpoint` sits in front of the real `ApiEndpoint` and gates access.
- Each policy tracks per-caller state so different clients are throttled independently.

## Run

```
javac *.java
java Main
```
