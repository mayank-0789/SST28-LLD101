public class RuleConfig {
    public final double cgrThreshold;
    public final int attendanceThreshold;
    public final int creditsThreshold;

    public RuleConfig(double cgrThreshold, int attendanceThreshold, int creditsThreshold) {
        this.cgrThreshold = cgrThreshold;
        this.attendanceThreshold = attendanceThreshold;
        this.creditsThreshold = creditsThreshold;
    }
}
