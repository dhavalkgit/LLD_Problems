package observer_design_pattern;

import java.util.Objects;

public class EmailNotification implements Notification{
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void send() {
        System.out.println("Notification is sent on email "+ email);
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
                "email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailNotification that = (EmailNotification) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
