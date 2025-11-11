package ru.jdevflow.otp.usecase.otp;

import ru.jdevflow.otp.domain.otp.commands.CreateOtpCommand;
import ru.jdevflow.otp.usecase.otp.views.OtpIdView;

public interface CreateOtpApi {

    void execute(CreateOtpCommand createOtpCommand, OtpIdView otpIdView);
}
