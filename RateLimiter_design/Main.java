public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThrottlePolicy policy = new RollingWindowPolicy(5000, 3);
        ApiEndpoint endpoint = new ApiEndpoint();
        Throttle throttled = new ThrottledEndpoint(policy, endpoint);

        String caller = "client-1";

        for (int i = 0; i < 5; i++) {
            System.out.println(throttled.handleCall(caller));
            Thread.sleep(1000);
        }
    }
}
