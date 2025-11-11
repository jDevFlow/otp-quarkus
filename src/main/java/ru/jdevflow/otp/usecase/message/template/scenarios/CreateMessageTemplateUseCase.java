package ru.jdevflow.otp.usecase.message.template.scenarios;

import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplate;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateFactory;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateModel;
import ru.jdevflow.otp.usecase.message.template.CreateMessageTemplateApi;
import ru.jdevflow.otp.usecase.message.template.gateway.MessageTemplateGateway;
import ru.jdevflow.otp.usecase.message.template.providers.AccountIdProvider;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateView;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMessageTemplateUseCase implements CreateMessageTemplateApi {

    private final Supplier<UUID> generatorId;
    private final AccountIdProvider accountIdProvider;
    private final MessageTemplateFactory messageTemplateFactory;
    private final MessageTemplateGateway messageTemplateGateway;

    @Override
    public void execute(CreateMessageTemplateCommand command, MessageTemplateView presenter) {
        MessageTemplateModel messageTemplate =
                (MessageTemplateModel) messageTemplateFactory.create(
                        generatorId,
                        accountIdProvider::invoke,
                        command);

        messageTemplateGateway.persist(messageTemplate);
    }
}
