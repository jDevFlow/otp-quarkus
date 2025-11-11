package ru.jdevflow.otp.domain.message.template.commands;

import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

/**
 * Команда создания шаблона сообщения.
 *
 * @param flowType       тип потока данных
 * @param language       язык шаблона
 * @param messageContent содержимое сообщения
 */
public record UpdateMessageTemplateCommand(
        String flowType,
        String language,
        MessageContent messageContent) {
}
