package ru.jdevflow.otp.domain.common.bus;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import java.util.Collection;

public interface DomainEventPublisher {

    void publish(Collection<DomainEvent> domainEvents);
}
