package ru.jdevflow.otp.domain.otp.model.vo;

public record BehaviorOtp(
       String callback,
       String rejectURL,
       String successURL) {
}
