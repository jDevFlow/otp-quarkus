package ru.jdevflow.otp.usecase.otp.scenarios;

import ru.jdevflow.otp.domain.otp.model.Otp;
import ru.jdevflow.otp.domain.otp.model.OtpModel;
import ru.jdevflow.otp.usecase.otp.CheckOtpApi;
import ru.jdevflow.otp.usecase.otp.gateway.OtpGateway;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOtpUseCase implements CheckOtpApi {

    private final OtpGateway otpGateway;
    private final Supplier<Instant> currentDateTime;

    @Override
    public void execute(UUID otpId, String checkValue) {
        Optional<Otp> otpOptional = otpGateway.getOtpById(otpId);
        if (otpOptional.isEmpty()) {
            throw  new IllegalStateException("Otp with id " + otpId + " not found");
        }
        OtpModel otp = (OtpModel) otpOptional.get();
        otp.checkContentValue(checkValue, currentDateTime);
        otpGateway.persist(otp);
    }
}
