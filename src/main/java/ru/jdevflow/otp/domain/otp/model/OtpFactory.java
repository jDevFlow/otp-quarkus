package ru.jdevflow.otp.domain.otp.model;

import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

public interface OtpFactory {

    Otp create(Supplier<UUID> generatorId,
               CreateOtpCommand createOtpCommand,
               Supplier<String> generateCode,
               Supplier<Instant> currentDateTime);

    OtpModel reconstitute(UUID otpId,
                          Long version,
                          SendDirection sendDirection,
                          ApplicationId applicationId,
                          String flowType,
                          String audienceId,
                          String language,
                          CheckContent checkContent,
                          Instant expiryDate,
                          Instant generateAt,
                          Instant lastAttemptAt,
                          Integer countAttempt,
                          BehaviorOtp behaviorOtp);
}
