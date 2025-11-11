package ru.jdevflow.otp.infrastructure.otp.rest.dto;

import java.util.UUID;

public record CheckOtpRequest(UUID otpId, String knowledge) {
}
