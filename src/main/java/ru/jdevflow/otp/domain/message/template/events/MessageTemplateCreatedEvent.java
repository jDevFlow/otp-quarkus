package ru.jdevflow.otp.domain.message.template.events;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

import lombok.Getter;

@Getter
public class MessageTemplateCreatedEvent extends DomainEvent {

    private final String applicationId;
    private final String flowType;
    private final String language;
    private final MessageContent messageContent;

    public MessageTemplateCreatedEvent(String aggregateId,
                                       String aggregateType,
                                       Long version,
                                       String applicationId,
                                       String flowType,
                                       String language,
                                       MessageContent messageContent) {
        super(aggregateId, aggregateType, version);
        this.applicationId = applicationId;
        this.flowType = flowType;
        this.language = language;
        this.messageContent = messageContent;
    }
}
