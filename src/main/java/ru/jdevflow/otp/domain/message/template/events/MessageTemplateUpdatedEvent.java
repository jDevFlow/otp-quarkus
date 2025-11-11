package ru.jdevflow.otp.domain.message.template.events;

import ru.jdevflow.otp.domain.common.events.DomainEvent;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

import lombok.Getter;

/**
 * Событие об обновлении шаблона сообщения.
 */
@Getter
public class MessageTemplateUpdatedEvent extends DomainEvent {

    private final String flowType;
    private final String language;
    private final MessageContent messageContent;

    public MessageTemplateUpdatedEvent(String aggregateId,
                                       String aggregateType,
                                       Long version,
                                       String flowType,
                                       String language,
                                       MessageContent messageContent) {
        super(aggregateId, aggregateType, version);
        this.flowType = flowType;
        this.language = language;
        this.messageContent = messageContent;
    }
}
