package ru.jdevflow.otp.domain.message.template.model;

import ru.jdevflow.otp.domain.common.types.AggregateRoot;
import ru.jdevflow.otp.domain.common.types.Version;
import ru.jdevflow.otp.domain.message.template.commands.UpdateMessageTemplateCommand;
import ru.jdevflow.otp.domain.message.template.events.MessageTemplateCreatedEvent;
import ru.jdevflow.otp.domain.message.template.events.MessageTemplateUpdatedEvent;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;
import ru.jdevflow.otp.domain.message.template.model.vo.MetaData;
import java.util.UUID;

import lombok.Getter;

@Getter
public class MessageTemplateModel extends AggregateRoot<UUID> implements MessageTemplate {

    private MetaData metaData;

    private MessageContent content;

    MessageTemplateModel(UUID id, MetaData metaData, MessageContent content) {
        super(id, Version.init());

        this.metaData = metaData;
        this.content = content;
        addEvent(new MessageTemplateCreatedEvent(
                getId().toString(),
                getAggregateType(),
                getVersion().toLongValue(),
                this.metaData.applicationId(),
                this.metaData.flowType(),
                this.metaData.language(),
                this.content));
    }

    public void update(UpdateMessageTemplateCommand command) {
        this.metaData = new MetaData(
                this.metaData.accountId(),
                this.metaData.applicationId(),
                command.flowType(),
                command.language());
        this.content = command.messageContent();

        addEvent(new MessageTemplateUpdatedEvent(
                getId().toString(),
                getAggregateType(),
                getVersion().toLongValue(),
                this.metaData.flowType(),
                this.metaData.language(),
                this.content));
    }

}
