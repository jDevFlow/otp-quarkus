package ru.jdevflow.otp.infrastructure.otp.rest.dto;

import java.util.UUID;

public record CheckOtpResponse(UUID otpId, String knowledge) {
}
