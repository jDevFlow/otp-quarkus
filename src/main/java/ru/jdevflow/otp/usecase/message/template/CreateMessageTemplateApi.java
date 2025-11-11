package ru.jdevflow.otp.usecase.message.template;

import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateView;

public interface CreateMessageTemplateApi {

    void execute(CreateMessageTemplateCommand command, MessageTemplateView presenter);
}
