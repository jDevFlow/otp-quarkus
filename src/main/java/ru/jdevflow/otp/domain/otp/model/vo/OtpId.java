package ru.jdevflow.otp.domain.otp.model.vo;

import lombok.Getter;

/**
 * Идентификатор OTP.
 */
@Getter
public class OtpId {

    private final String value;

    OtpId(String value) {
        this.value = value;
    }

    public static OtpId of(String value) {
        if (value == null) {
            throw new IllegalArgumentException("OtpId value is null");
        }
        return new OtpId(value);
    }

    public interface GeneratorId {

    }

}
