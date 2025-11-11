package ru.jdevflow.otp.domain.common.types;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import java.util.Collection;

public abstract class AggregateRoot<T> extends DomainEntity<T> {

    protected String type;

    protected AggregateRoot(final T id, Version version) {
        super(id, version);
        this.type = getAggregateType();
    }

    public String getAggregateType() {
        return this.getClass().getSimpleName()
                .replace("Domain", "")
                .replaceAll("(?<=[a-z])([A-Z])", "_$1");
    }

    public Collection<DomainEvent> getEvents() {
        return popEvents();
    }
}
