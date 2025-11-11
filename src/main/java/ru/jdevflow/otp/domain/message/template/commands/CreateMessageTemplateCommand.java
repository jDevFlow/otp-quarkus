package ru.jdevflow.otp.domain.message.template.commands;

import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

/**
 * Команда создания шаблона сообщения.
 *
 * @param applicationId  идентификатор приложения
 * @param flowType       тип потока данных
 * @param language       язык шаблона
 * @param messageContent содержимое сообщения
 */
public record CreateMessageTemplateCommand(
        String applicationId,
        String flowType,
        String language,
        MessageContent messageContent) {
}
