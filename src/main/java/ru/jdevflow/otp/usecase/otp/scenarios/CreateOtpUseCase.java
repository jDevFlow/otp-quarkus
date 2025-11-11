package ru.jdevflow.otp.usecase.otp.scenarios;

import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.domain.otp.model.OtpFactory;
import ru.jdevflow.otp.domain.otp.model.OtpModel;
import ru.jdevflow.otp.usecase.otp.CreateOtpApi;
import ru.jdevflow.otp.usecase.otp.gateway.OtpGateway;
import ru.jdevflow.otp.usecase.otp.views.OtpIdView;

import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOtpUseCase implements CreateOtpApi {

    private final Supplier<UUID> generatorId;
    private final Supplier<String> generateCode;
    private final Supplier<Instant> currentDateTime;
    private final OtpFactory otpFactory;
    private final OtpGateway otpGateway;

    @Override
    public void execute(CreateOtpCommand createOtpCommand, OtpIdView otpIdView) {
        OtpModel otpModel =
                (OtpModel) otpFactory.create(generatorId, createOtpCommand, generateCode, currentDateTime);

        otpGateway.persist(otpModel);
        otpIdView.present(otpModel);
    }
}
