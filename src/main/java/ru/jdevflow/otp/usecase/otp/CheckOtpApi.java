package ru.jdevflow.otp.usecase.otp;

import java.util.UUID;

public interface CheckOtpApi {

    void execute(UUID otpId, String knowledge);
}
