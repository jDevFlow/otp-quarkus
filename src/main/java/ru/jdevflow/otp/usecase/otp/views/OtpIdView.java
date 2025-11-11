package ru.jdevflow.otp.usecase.otp.views;

import ru.jdevflow.otp.domain.otp.model.OtpModel;
import java.util.UUID;

public interface OtpIdView {

    UUID getViewModel();

    void present(OtpModel otpModel);
}
