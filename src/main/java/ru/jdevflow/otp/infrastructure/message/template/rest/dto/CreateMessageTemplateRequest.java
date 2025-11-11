package ru.jdevflow.otp.infrastructure.message.template.rest.dto;

import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

public record CreateMessageTemplateRequest(String applicationId,
                                           String flowType,
                                           String language,
                                           MessageContent messageContent) {

    public CreateMessageTemplateCommand toCommand() {
        return new CreateMessageTemplateCommand(applicationId, flowType, language, messageContent);
    }
}
