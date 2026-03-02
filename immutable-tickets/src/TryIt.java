import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Demonstrates immutability:
 * - service "updates" return NEW ticket instances; originals are unchanged.
 * - attempting to mutate the tags list throws UnsupportedOperationException.
 * - no setters exist; direct field mutation does not compile.
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        // 1. Create a ticket — all validation fires inside build()
        IncidentTicket original = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created:          " + original);

        // 2. "assign" returns a NEW ticket; original is untouched
        IncidentTicket assigned = service.assign(original, "agent@example.com");
        System.out.println("\nAssigned:         " + assigned);
        System.out.println("Original unchanged: " + original.getAssigneeEmail()); // still null

        // 3. "escalate" also returns a NEW ticket; assigned is untouched
        IncidentTicket escalated = service.escalateToCritical(assigned);
        System.out.println("\nEscalated:        " + escalated);
        System.out.println("Assigned unchanged: " + assigned.getPriority()); // still MEDIUM

        // 4. Prove the tags list is sealed — mutation throws UnsupportedOperationException
        List<String> tags = escalated.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("\nERROR: tag mutation succeeded — immutability broken!");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nTag mutation blocked — immutability confirmed.");
        }
    }
}
