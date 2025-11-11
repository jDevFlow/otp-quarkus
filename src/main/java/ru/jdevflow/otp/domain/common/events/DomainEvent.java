package ru.jdevflow.otp.domain.common.events;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected final UUID id;
    protected final String aggregateId;
    protected final String aggregateType;
    protected final Long version;
    protected final String eventType;
    protected final OffsetDateTime createdAt;

    protected DomainEvent(String aggregateId, String aggregateType, Long version) {
        this.version = version;
        this.id = UUID.randomUUID();
        this.aggregateType = aggregateType;
        this.eventType = getEventType();
        this.createdAt = OffsetDateTime.now();
        Objects.requireNonNull(aggregateId);
        if (aggregateId.isBlank()) throw new IllegalArgumentException("DomainEvent aggregateId is required");
        this.aggregateId = aggregateId;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventType() {
        return this.getClass().getSimpleName()
                .replace("Event", "")
                .replaceAll("(?<=[a-z])([A-Z])", "_$1");
    }
}
