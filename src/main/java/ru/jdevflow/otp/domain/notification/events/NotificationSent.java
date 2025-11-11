package ru.jdevflow.otp.domain.notification.events;

import ru.jdevflow.otp.domain.common.events.DomainEvent;

public class NotificationSent extends DomainEvent {



    public NotificationSent(String aggregateId, String aggregateType, Long version) {
        super(aggregateId, aggregateType, version);
    }
}
