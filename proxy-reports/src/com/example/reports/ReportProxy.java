package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();

    private RealReport realReport; // Lazy-loaded real report

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("Access Denied: " + user.getName() + " cannot access " + title);
            return;
        }
        if (realReport == null) {
            System.out.println("Loading report: " + title);
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("Using cached report: " + title);
        }
        realReport.display(user);
    }
}
