package ru.jdevflow.otp.domain.message.template.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.jdevflow.otp.domain.message.template.commands.CreateMessageTemplateCommand;
import ru.jdevflow.otp.domain.message.template.model.vo.MessageContent;

import java.util.UUID;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultMessageTemplateFactoryTest {

    private static final UUID ID = UUID.fromString("0199a42a-6bc3-7921-9254-66aa53b1b8fd");
    private static final String USER_ACCOUNT_ID = "user-account-id";

    @Test
    void givenCreateCommand_whenCreate_thenCorrect() {
        //given
        Supplier<UUID> generatorId = () -> ID;
        Supplier<String> accountIdProvider = () -> USER_ACCOUNT_ID;
        DefaultMessageTemplateFactory factory = new DefaultMessageTemplateFactory();
        MessageContent messageContent = new MessageContent("m-titte", "m-content");
        CreateMessageTemplateCommand command = new CreateMessageTemplateCommand(
                "applicationId",
                "change-password-flow",
                "en",
                messageContent
        );
        //when
        MessageTemplateModel messageTemplate = (MessageTemplateModel) factory.create(generatorId, accountIdProvider, command);
        //then
        assertNotNull(messageTemplate);
        assertFalse(messageTemplate.popEvents().isEmpty());
        assertEquals(ID, messageTemplate.getId());
        assertEquals(USER_ACCOUNT_ID, messageTemplate.getMetaData().accountId());
        assertEquals(messageContent, messageTemplate.getContent());
    }
}