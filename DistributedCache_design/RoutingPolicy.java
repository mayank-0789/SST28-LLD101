public interface RoutingPolicy {
    int resolveIndex(String key, int total);
}
