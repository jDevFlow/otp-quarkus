package ru.jdevflow.otp.infrastructure.message.template.gateway;

import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.data.MessageTemplateData;

public interface MessageTemplateRepository {

    void save(MessageTemplateData messageTemplateData);

    MessageTemplateData search(String filter);
}
