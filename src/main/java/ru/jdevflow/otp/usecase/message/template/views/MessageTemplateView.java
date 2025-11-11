package ru.jdevflow.otp.usecase.message.template.views;

import ru.jdevflow.otp.domain.message.template.model.MessageTemplate;

public interface MessageTemplateView {

    MessageTemplateViewModel getViewModel();

    void present(MessageTemplate messageTemplate);
}
