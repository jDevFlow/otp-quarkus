package ru.jdevflow.otp.domain.message.template.model;

import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Фабрика создания и восстановления сообщений
 */
public interface MessageTemplateFactory {

    /**
     * Метод создания шаблона сообщения.
     *<p>
     * @param generatorId       генератор идентификатора
     * @param accountIdProvider поставщик идентификатора аккаунта
     * @param command           команда на создание шаблона сообщения
     * @return MessageTemplate шаблон сообщения
     */
    MessageTemplate create(
            Supplier<UUID> generatorId,
            Supplier<String> accountIdProvider,
            CreateMessageTemplateCommand command);
}
