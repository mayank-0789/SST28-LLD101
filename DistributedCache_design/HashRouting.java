public class HashRouting implements RoutingPolicy {
    @Override
    public int resolveIndex(String key, int total) {
        return Math.abs(key.hashCode()) % total;
    }
}
