public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        String phone = n.phone;
        if (phone == null || phone.isEmpty()) {
            phone = "unknown";
        }
        System.out.println("WA -> to=" + phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
