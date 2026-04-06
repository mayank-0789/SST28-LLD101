public interface ThrottlePolicy {
    boolean allowRequest(String callerId);
}
