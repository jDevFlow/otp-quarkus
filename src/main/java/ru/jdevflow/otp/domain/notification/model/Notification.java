package ru.jdevflow.otp.domain.notification.model;

import ru.jdevflow.otp.domain.notification.model.vo.NotificationStatus;
import java.util.Map;
import java.util.UUID;

public interface Notification {

    UUID getId();

    String getChannel();

    String getTo();

    String getLanguage();

    NotificationStatus getStatus();

    /**
     * Формируется из message template
     *
     * @return
     */
    String getTemplateContent();


    /**
     * Формируется из message template
     *
     * @return
     */
    String getTextContent();
    /**
     * Данные из OTP
     *
     * @return
     */
    Map<String, Object> getData();

}
