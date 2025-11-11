package ru.jdevflow.otp.infrastructure.message.template.gateway;

import ru.jdevflow.otp.domain.message.template.model.MessageTemplate;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateModel;
import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.MessageTemplateMapper;
import ru.jdevflow.otp.usecase.message.template.gateway.MessageTemplateGateway;
import ru.jdevflow.otp.usecase.message.template.query.MessageTemplateSearch;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageTemplateDsGateway implements MessageTemplateGateway {

    private final MessageTemplateRepository repository;
    private final MessageTemplateMapper mapper;

    @Override
    public void persist(MessageTemplateModel messageTemplate) {
        repository.save(mapper.messageTemplateModelToMessageTemplateData(messageTemplate));
    }

    @Override
    public Optional<MessageTemplate> search(MessageTemplateSearch search) {
        return Optional.empty();
    }
}
