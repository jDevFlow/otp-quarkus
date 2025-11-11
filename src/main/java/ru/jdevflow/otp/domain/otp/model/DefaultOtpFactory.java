package ru.jdevflow.otp.domain.otp.model;

import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class DefaultOtpFactory implements OtpFactory {

    @Override
    public Otp create(Supplier<UUID> generatorId,
                      CreateOtpCommand createOtpCommand,
                      Supplier<String> generateCode,
                      Supplier<Instant> currentDateTime) {

        // проверяем все данные перед созданием объекта TODO собрать ошибки с помощью Either
        Objects.requireNonNull(createOtpCommand.sendDirection());
        Objects.requireNonNull(createOtpCommand.applicationId());
        Objects.requireNonNull(createOtpCommand.flowType());
        Objects.requireNonNull(createOtpCommand.audienceId());
        Objects.requireNonNull(createOtpCommand.language());

        Objects.requireNonNull(createOtpCommand.checkContent());

        Objects.requireNonNull(createOtpCommand.callback());
        Objects.requireNonNull(createOtpCommand.rejectURL());
        Objects.requireNonNull(createOtpCommand.successURL());

        return new OtpModel(generatorId.get(), createOtpCommand, generateCode, currentDateTime);
    }

    @Override
    public OtpModel reconstitute(UUID otpId, Long version, SendDirection sendDirection, ApplicationId applicationId, String flowType, String audienceId, String language, CheckContent checkContent, Instant expiryDate, Instant generateAt, Instant lastAttemptAt, Integer countAttempt, BehaviorOtp behaviorOtp) {

        return new OtpModel(otpId, version, sendDirection, applicationId, flowType, audienceId, language, checkContent, expiryDate, generateAt, lastAttemptAt, countAttempt, behaviorOtp);
    }
}
