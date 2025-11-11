package ru.jdevflow.otp.domain.message.template.model;

import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;
import ru.jdevflow.otp.domain.message.template.model.vo.MetaData;
import java.util.UUID;

public interface MessageTemplate {

    /**
     * Идентификатор сообщения.
     *
     * @return UUID
     */
    UUID getId();

    /**
     * Возвращает мета данные о шаблоне.
     * Кто создал для чего, в каком направлении потоков данных участвует шаблон.
     *
     * @return MetaData
     */
    MetaData getMetaData();

    /**
     * Возвращает контент
     *
     * @return MessageContent
     */
    MessageContent getContent();

}
