package ru.jdevflow.otp.domain.notification.model.vo;

public enum NotificationStatus {

    CREATED("created"),
    SENDED("sended"),
    ERROR("error"),
    ;

    private final String label;


    NotificationStatus(String label) {
        this.label = label;
    }
}
