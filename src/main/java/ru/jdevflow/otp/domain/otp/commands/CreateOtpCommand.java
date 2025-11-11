package ru.jdevflow.otp.domain.otp.commands;

import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;

public record CreateOtpCommand(
        SendDirection sendDirection,
        ApplicationId applicationId,
        String flowType,
        String audienceId,
        String language,
        CheckContent checkContent,
        Instant expiryDate,
        String callback,
        String rejectURL,
        String successURL) {
}
