package ru.jdevflow.otp.infrastructure.otp.gateway;

import ru.jdevflow.otp.domain.otp.model.Otp;
import ru.jdevflow.otp.domain.otp.model.OtpFactory;
import ru.jdevflow.otp.domain.otp.model.OtpModel;
import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.data.OtpData;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.OtpDataMapper;
import ru.jdevflow.otp.usecase.otp.gateway.OtpGateway;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OtpDsGateway implements OtpGateway {

    private final OtpRepository otpRepository;
    private final OtpDataMapper otpDataMapper;
    private final OtpFactory otpFactory;

    @Override
    public void persist(OtpModel otpModel) {
        otpRepository.save(otpDataMapper.otpModelToOtpData(otpModel));
    }

    @Override
    public Optional<Otp> getOtpById(UUID otpId) {
        OtpData otpData = otpRepository.getById(otpId.toString());
        if (otpData == null) {
            return Optional.empty();
        }
        OtpModel otpModel = otpFactory.reconstitute(
                otpData.getId(),
                otpData.getVersion(),
                new SendDirection(
                        otpData.getSendDirection().channel(),
                        otpData.getSendDirection().to()),
                new ApplicationId(otpData.getApplicationId().value()),
                otpData.getFlowType(),
                otpData.getAudienceId(),
                otpData.getLanguage(),
                new CheckContent(
                        otpData.getCheckContent().generateCode(),
                        otpData.getCheckContent().value()),
                otpData.getExpiryDate(),
                otpData.getGenerateAt(),
                otpData.getLastAttemptAt(),
                otpData.getCountAttempt(),
                new BehaviorOtp(
                        otpData.getBehaviorOtp().callback(),
                        otpData.getBehaviorOtp().rejectURL(),
                        otpData.getBehaviorOtp().successURL())
        );
        return Optional.of(otpModel);
    }
}
