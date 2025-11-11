package ru.jdevflow.otp.usecase.otp.views;

public interface CheckOtpResultView {

    CheckOtpResultViewModel getViewModel();

    void present(boolean checkResult);
}
