package ru.jdevflow.otp.domain.otp.events;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;

import lombok.Getter;

@Getter
public class OtpCreatedEvent extends DomainEvent {

    private static final String AGGREGATE_TYPE = "OTP";

    private SendDirection sendDirection;
    private ApplicationId applicationId;
    private String flowType;
    private String audienceId;
    private String language;
    private CheckContent checkContent;
    private Instant expiryDate;
    private Instant generateAt;
    private Integer countAttempt;
    private BehaviorOtp behaviorOtp;

    public OtpCreatedEvent(String aggregateId,
                           String aggregateType,
                           Long version,
                           SendDirection sendDirection,
                           ApplicationId applicationId,
                           String flowType,
                           String audienceId,
                           String language,
                           CheckContent checkContent,
                           Instant expiryDate,
                           Instant generateAt,
                           Integer countAttempt,
                           BehaviorOtp behaviorOtp) {
        super(aggregateId, aggregateType, version);
        this.sendDirection = sendDirection;
        this.applicationId = applicationId;
        this.flowType = flowType;
        this.audienceId = audienceId;
        this.language = language;
        this.checkContent = checkContent;
        this.expiryDate = expiryDate;
        this.generateAt = generateAt;
        this.countAttempt = countAttempt;
        this.behaviorOtp = behaviorOtp;
    }
}
