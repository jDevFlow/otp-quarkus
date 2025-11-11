package ru.jdevflow.otp.usecase.notification.rules;

import ru.jdevflow.otp.domain.common.bus.DomainEventListener;
import ru.jdevflow.otp.domain.notification.events.NotificationCreatedEvent;
import ru.jdevflow.otp.usecase.notification.scenarios.SendNotificationHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SendNotificationAfterCreatedRule implements DomainEventListener<NotificationCreatedEvent> {

    private final SendNotificationHandler sendNotificationHandler;

    @Override
    public Class<?> eventType() {
        return null;
    }

    @Override
    public void handle(NotificationCreatedEvent event) {

    }
}
