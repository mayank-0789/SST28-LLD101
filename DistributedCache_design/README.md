# Distributed Cache - LLD

Multi-shard cache with LRU eviction and transparent database fallback.

## Core classes

- `ShardedStore` - main coordinator that distributes keys across shards
- `Shard` - wraps a single LRU cache instance
- `EvictingMap` - LRU implementation using `LinkedHashMap` with access-order
- `RoutingPolicy` - strategy interface for deciding which shard gets a key
- `HashRouting` - routes via `hashCode() % shardCount`
- `Datastore` - simulated persistent storage for cache misses

## Design

- **Strategy pattern** for routing — easy to swap in consistent hashing or round-robin later.
- On cache miss, the store transparently fetches from `Datastore` and warms the shard.
- Each shard has its own `EvictingMap` so eviction is local and doesn't affect other shards.

## Run

```
javac *.java
java Main
```
