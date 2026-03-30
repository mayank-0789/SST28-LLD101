public class Customer {
    private String emailId;
    private String fullName;

    public Customer(String emailId, String fullName) {
        this.emailId = emailId;
        this.fullName = fullName;
    }

    public String getEmailId() { return emailId; }
    public String getFullName() { return fullName; }
}
