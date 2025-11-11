package ru.jdevflow.otp.domain.otp.model;

import ru.jdevflow.otp.domain.common.types.AggregateRoot;
import ru.jdevflow.otp.domain.common.types.Version;
import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.domain.otp.events.OtpCheckedEvent;
import ru.jdevflow.otp.domain.otp.events.OtpCreatedEvent;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.Getter;

@Getter
public class OtpModel extends AggregateRoot<UUID> implements Otp {

    private SendDirection sendDirection;
    private ApplicationId applicationId;
    private String flowType;
    private String audienceId;
    private String language;
    private CheckContent checkContent;
    private Instant expiryDate;

    private Instant generateAt;
    private Instant lastAttemptAt;
    private Integer countAttempt;
    private Boolean lastAttemptResult;

    private BehaviorOtp behaviorOtp;

    OtpModel(UUID otpId, Long version , SendDirection sendDirection, ApplicationId applicationId, String flowType, String audienceId, String language, CheckContent checkContent, Instant expiryDate, Instant generateAt, Instant lastAttemptAt, Integer countAttempt, BehaviorOtp behaviorOtp) {
        super(otpId, Version.of(version));
        this.sendDirection = sendDirection;
        this.applicationId = applicationId;
        this.flowType = flowType;
        this.audienceId = audienceId;
        this.language = language;
        this.checkContent = checkContent;
        this.expiryDate = expiryDate;
        this.generateAt = generateAt;
        this.lastAttemptAt = lastAttemptAt;
        this.countAttempt = countAttempt;
        this.behaviorOtp = behaviorOtp;
    }

    OtpModel(UUID otpId, CreateOtpCommand command,
             Supplier<String> generateCode,
             Supplier<Instant> currentDateTime) {
        super(otpId, Version.init());

        this.sendDirection = command.sendDirection();
        this.applicationId = command.applicationId();
        this.flowType = command.flowType();
        this.language = command.language();
        this.audienceId = command.audienceId();
        this.checkContent = command.checkContent().generateCode() ?
                new CheckContent(true, generateCode.get()) :
                command.checkContent();

        this.behaviorOtp = new BehaviorOtp(command.callback(), command.rejectURL(), command.successURL());
        this.expiryDate = command.expiryDate() != null ? command.expiryDate() : currentDateTime.get().plusSeconds(62);

        this.generateAt = currentDateTime.get();
        this.lastAttemptAt = null;
        this.countAttempt = 0;
        addEvent(new OtpCreatedEvent(
                getId().toString(),
                getAggregateType(),
                getVersion().toLongValue(),
                this.sendDirection,
                this.applicationId,
                this.flowType,
                this.audienceId,
                this.language,
                this.checkContent,
                this.expiryDate,
                this.generateAt,
                this.countAttempt,
                this.behaviorOtp
        ));
    }

    public boolean checkContentValue(String value, Supplier<Instant> currentDateTime) {
        this.lastAttemptAt = currentDateTime.get();
        this.countAttempt++;
        this.lastAttemptResult = this.checkContent.value().equals(value);
        addEvent(new OtpCheckedEvent(
                getId().toString(),
                getAggregateType(),
                getVersion().toLongValue(),
                this.lastAttemptResult));

        return this.lastAttemptResult;
    }

}
