public class ThrottledEndpoint implements Throttle {
    private final ThrottlePolicy policy;
    private final ApiEndpoint endpoint;

    public ThrottledEndpoint(ThrottlePolicy policy, ApiEndpoint endpoint) {
        this.policy = policy;
        this.endpoint = endpoint;
    }

    @Override
    public String handleCall(String callerId) {
        if (policy.allowRequest(callerId)) {
            return endpoint.handleCall(callerId);
        }
        return "REJECTED - rate limit hit for: " + callerId;
    }
}
