package br.com.gustavoakira.library.notification.application.domain;

import br.com.gustavoakira.library.common.exception.InvalidDomainConversionException;
import br.com.gustavoakira.library.notification.application.domain.value_object.NotificationStatus;

import java.util.Objects;

public class Notification{
    private Long id;
    private String email;
    private String value;
    private NotificationStatus status;

    public Notification(Long id,String email, String value, NotificationStatus status) {
        this.id = id;
        this.email = email;
        this.value = value;
        this.status = status;
        this.validate();
    }

    public Notification(String email, String value) {
        this.email = email;
        this.value = value;
        status = NotificationStatus.start();
        this.validate();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getValue() {
        return value;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    private void validate(){
        if(this.email == null || this.email.isEmpty()){
            throw new InvalidDomainConversionException("Email cannot be null or empty");
        }

        if(this.value == null || this.value.isEmpty()){
            throw new InvalidDomainConversionException("Value cannot be null or empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return email.equals(that.email) && value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, value);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", value='" + value + '\'' +
                ", status=" + status +
                '}';
    }
}
