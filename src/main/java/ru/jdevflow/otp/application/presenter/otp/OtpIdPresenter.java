package ru.jdevflow.otp.application.presenter.otp;

import ru.jdevflow.otp.domain.otp.model.OtpModel;
import ru.jdevflow.otp.usecase.otp.views.OtpIdView;
import java.util.UUID;

public class OtpIdPresenter implements OtpIdView {

    private OtpModel otpModel;

    @Override
    public UUID getViewModel() {
        return this.otpModel.getId();
    }

    @Override
    public void present(OtpModel otpModel) {
        this.otpModel = otpModel;
    }
}
