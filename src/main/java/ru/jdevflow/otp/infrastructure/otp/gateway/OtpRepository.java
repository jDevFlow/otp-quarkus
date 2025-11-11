package ru.jdevflow.otp.infrastructure.otp.gateway;

import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.data.OtpData;

public interface OtpRepository {

    void save(OtpData otpData);

    OtpData getById(String otpId);
}
