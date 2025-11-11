package ru.jdevflow.otp.application.presenter.otp;

import ru.jdevflow.otp.usecase.otp.views.CheckOtpResultView;
import ru.jdevflow.otp.usecase.otp.views.CheckOtpResultViewModel;

public class CheckOtpResultPresenter implements CheckOtpResultView {

    private CheckOtpResultViewModel viewModel;

    @Override
    public CheckOtpResultViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public void present(boolean checkResult) {
        this.viewModel = new CheckOtpResultViewModel(checkResult);
    }
}
