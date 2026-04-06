import java.util.ArrayList;
import java.util.List;

public class ShardedStore {
    private final List<Shard> shards;
    private final RoutingPolicy router;
    private final Datastore store;

    public ShardedStore(int shardCount, int shardCapacity) {
        this.router = new HashRouting();
        this.store = new Datastore();
        this.shards = new ArrayList<>();

        for (int i = 0; i < shardCount; i++) {
            shards.add(new Shard(shardCapacity));
        }
    }

    public String get(String key) {
        int idx = router.resolveIndex(key, shards.size());
        Shard shard = shards.get(idx);

        if (shard.has(key)) {
            return shard.get(key);
        }

        String val = store.lookup(key);
        shard.put(key, val);
        return val;
    }

    public void put(String key, String value) {
        int idx = router.resolveIndex(key, shards.size());
        shards.get(idx).put(key, value);
    }
}
