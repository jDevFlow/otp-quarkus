package ru.jdevflow.otp.usecase.otp.gateway;

import ru.jdevflow.otp.domain.otp.model.Otp;
import ru.jdevflow.otp.domain.otp.model.OtpModel;
import java.util.Optional;
import java.util.UUID;

public interface OtpGateway {

    void persist(OtpModel otpModel);

    Optional<Otp> getOtpById(UUID otpId);
}
