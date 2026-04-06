import java.util.LinkedHashMap;

public class EvictingMap {
    private final int maxSize;
    private final LinkedHashMap<String, String> entries;

    public EvictingMap(int maxSize) {
        this.maxSize = maxSize;
        this.entries = new LinkedHashMap<>(maxSize, 0.75f, true);
    }

    public String get(String key) {
        return entries.get(key);
    }

    public void put(String key, String value) {
        if (!entries.containsKey(key) && entries.size() >= maxSize) {
            String oldest = entries.keySet().iterator().next();
            entries.remove(oldest);
        }
        entries.put(key, value);
    }

    public boolean has(String key) {
        return entries.containsKey(key);
    }
}
