package ru.jdevflow.otp.domain.message.template.model;

import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;
import ru.jdevflow.otp.domain.message.template.model.vo.MetaData;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class DefaultMessageTemplateFactory implements MessageTemplateFactory {

    @Override
    public MessageTemplate create(Supplier<UUID> generatorId,
                                  Supplier<String> accountIdProvider,
                                  CreateMessageTemplateCommand command) {
        Objects.requireNonNull(command);
        String applicationId = Objects.requireNonNull(command.applicationId());
        String flowType = Objects.requireNonNull(command.flowType());
        String language = Objects.requireNonNull(command.language());
        MessageContent messageContent = Objects.requireNonNull(command.messageContent());

        MetaData metaData = new MetaData(accountIdProvider.get(), applicationId, flowType, language);
        return new MessageTemplateModel(generatorId.get(), metaData, messageContent);
    }
}
