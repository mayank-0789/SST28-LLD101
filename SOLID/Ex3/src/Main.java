import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");

        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);

        RuleConfig config = new RuleConfig(8.0, 75, 20);

        List<EligibilityRule> rules = new ArrayList<>();
        rules.add(new DisciplinaryRule());
        rules.add(new CGRRule(config.cgrThreshold));
        rules.add(new AttendanceRule(config.attendanceThreshold));
        rules.add(new CreditsRule(config.creditsThreshold));

        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(s);
    }
}
