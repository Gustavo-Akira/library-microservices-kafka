package br.com.gustavoakira.library.notification.application.domain.value_object;

import java.util.Objects;

public class NotificationStatus{
    private final String status;
    private NotificationStatus(String status){
        this.status = status;
    }

    public static NotificationStatus finished(){
        return new NotificationStatus("finished");
    }
    public static NotificationStatus start(){
        return new NotificationStatus("start");
    }

    public static NotificationStatus cancelled(){
        return new NotificationStatus("cancelled");
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationStatus that = (NotificationStatus) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
