package ru.jdevflow.otp.infrastructure.otp.rest.dto;

import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;

public record CreateOtpDtoRequest(SendDirection sendDirection,
                                  ApplicationId applicationId,
                                  String flowType,
                                  String audienceId,
                                  String language,
                                  CheckContent checkContent,
                                  Instant expiryDate,
                                  String callback,
                                  String rejectURL,
                                  String successURL) {
    public CreateOtpCommand toCommand() {
        return new CreateOtpCommand(sendDirection, applicationId, flowType, audienceId, language, checkContent, expiryDate, callback, rejectURL, successURL);
    }
}
