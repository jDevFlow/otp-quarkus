package ru.jdevflow.otp.domain.otp.events;

import ru.jdevflow.otp.domain.common.events.DomainEvent;

import lombok.Getter;

@Getter
public class OtpCheckedEvent extends DomainEvent {

    private final boolean checkResult;

    public OtpCheckedEvent(String aggregateId, String aggregateType, Long version, boolean checkResult) {
        super(aggregateId, aggregateType, version);
        this.checkResult = checkResult;
    }
}
