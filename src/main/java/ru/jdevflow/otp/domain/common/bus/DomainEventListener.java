package ru.jdevflow.otp.domain.common.bus;

import ru.jdevflow.otp.domain.common.events.DomainEvent;

public interface DomainEventListener<T extends DomainEvent> {

    Class<?> eventType();

    void handle(T event);
}
