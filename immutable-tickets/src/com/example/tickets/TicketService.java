package com.example.tickets;

/**
 * Service layer that creates and "updates" tickets immutably.
 * All mutations produce a NEW IncidentTicket — the original is never changed.
 * All validation is handled by Builder.build().
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        return new IncidentTicket.Builder()
                .setId(id)
                .setReporterEmail(reporterEmail)
                .setTitle(title)
                .setPriority("MEDIUM")
                .setSource("CLI")
                .setCustomerVisible(false)
                .addTag("NEW")
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        return new IncidentTicket.Builder()
                .from(t)
                .setPriority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        return new IncidentTicket.Builder()
                .from(t)
                .setAssigneeEmail(assigneeEmail)
                .build();
    }
}
