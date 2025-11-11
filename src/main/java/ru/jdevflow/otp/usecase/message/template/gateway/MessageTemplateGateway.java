package ru.jdevflow.otp.usecase.message.template.gateway;

import ru.jdevflow.otp.domain.message.template.model.MessageTemplate;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateModel;
import ru.jdevflow.otp.usecase.message.template.query.MessageTemplateSearch;
import java.util.Optional;

public interface MessageTemplateGateway {

    void persist(MessageTemplateModel messageTemplate);

    Optional<MessageTemplate> search(MessageTemplateSearch search);
}
