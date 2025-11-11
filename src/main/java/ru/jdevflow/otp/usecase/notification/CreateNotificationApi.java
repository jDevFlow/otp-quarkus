package ru.jdevflow.otp.usecase.notification;

import ru.jdevflow.otp.domain.notification.commands.CreateNotificationCommand;

public interface CreateNotificationApi {

    void execute(CreateNotificationCommand command);
}
