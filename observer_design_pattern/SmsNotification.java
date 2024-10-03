package observer_design_pattern;

import java.util.Objects;

public class SmsNotification implements Notification{
    private String mobileNo;

    public SmsNotification(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public void send() {
        System.out.println("Notification is sent on mobile no "+ mobileNo);
    }

    @Override
    public String toString() {
        return "SmsNotification{" +
                "mobileNo='" + mobileNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsNotification that = (SmsNotification) o;
        return Objects.equals(mobileNo, that.mobileNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mobileNo);
    }
}
