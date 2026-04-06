public class Shard {
    private final EvictingMap cache;

    public Shard(int capacity) {
        this.cache = new EvictingMap(capacity);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public boolean has(String key) {
        return cache.has(key);
    }
}
