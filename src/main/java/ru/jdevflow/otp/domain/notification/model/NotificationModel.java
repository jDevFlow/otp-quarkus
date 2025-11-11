package ru.jdevflow.otp.domain.notification.model;

import ru.jdevflow.otp.domain.common.types.AggregateRoot;
import ru.jdevflow.otp.domain.common.types.Version;
import ru.jdevflow.otp.domain.notification.model.vo.NotificationStatus;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;

@Getter
public class NotificationModel extends AggregateRoot<UUID> implements Notification {

    private final UUID id;
    private final String channel;
    private final String to;
    private final String language;
    private final String templateContent;
    private final Map<String, Object> data;

    private String textContent;
    private NotificationStatus status;

    NotificationModel(UUID id, String channel, String to, String language, String templateContent, Map<String, Object> data) {
        super(id, Version.init());
        this.id = id;
        this.channel = channel;
        this.to = to;
        this.language = language;
        this.templateContent = templateContent;
        this.data = data;
        this.status = NotificationStatus.CREATED;

    }

}
