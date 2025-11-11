package ru.jdevflow.otp.usecase.notification.scenarios;

import ru.jdevflow.otp.domain.notification.commands.CreateNotificationCommand;
import ru.jdevflow.otp.usecase.notification.CreateNotificationApi;
import ru.jdevflow.otp.usecase.notification.providers.TemplateContentProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateNotificationUseCase implements CreateNotificationApi {

    private final TemplateContentProvider templateContentProvider;

    @Override
    public void execute(CreateNotificationCommand command) {


    }
}
