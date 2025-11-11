package ru.jdevflow.otp.domain.common.types;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class DomainEntity<T> {

    private final T id;
    private final Version version;
    private final String type;

    private Collection<DomainEvent> events = new ArrayList<>();

    protected DomainEntity(final T id, Version version) {
        this.id = id;
        this.version = version;
        this.type = getDomainType();
    }

    public void addEvent(DomainEvent domainEvent) {
        version.next();
        events.add(domainEvent);
    }


    public List<DomainEvent> popEvents() {
        var returnedEvents = List.copyOf(this.events);
        this.events = new ArrayList<>();
        return returnedEvents;
    }


    public String getDomainType() {
        return this.getClass().getSimpleName()
                .replace("Domain", "")
                .replaceAll("(?<=[a-z])([A-Z])", "_$1");
    }
}