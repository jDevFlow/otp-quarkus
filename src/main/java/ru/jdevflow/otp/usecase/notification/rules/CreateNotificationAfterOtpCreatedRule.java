package ru.jdevflow.otp.usecase.notification.rules;

import ru.jdevflow.otp.domain.common.bus.DomainEventListener;
import ru.jdevflow.otp.domain.notification.commands.CreateNotificationCommand;
import ru.jdevflow.otp.domain.otp.events.OtpCreatedEvent;
import ru.jdevflow.otp.usecase.notification.CreateNotificationApi;
import ru.jdevflow.otp.usecase.notification.providers.TemplateContentProvider;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Event Storming блок Policy фиолетовый
 * <p>
 * Правило создания уведомления после создания OTP.
 */
@Slf4j
@RequiredArgsConstructor
public class CreateNotificationAfterOtpCreatedRule implements DomainEventListener<OtpCreatedEvent> {

    private final CreateNotificationApi createNotificationApi;
    private final TemplateContentProvider templateContentProvider;

    @Override
    public Class<?> eventType() {
        return OtpCreatedEvent.class;
    }

    @Override
    public void handle(OtpCreatedEvent event) {
        log.info("Received OtpCreatedEvent [{}] , trigger start", event);
        String templateContent = templateContentProvider.invoke(
                event.getApplicationId().value(),
                event.getFlowType(),
                event.getLanguage()
        );
        CreateNotificationCommand createNotificationCommand = new CreateNotificationCommand(
                event.getSendDirection().channel(),
                event.getSendDirection().to(),
                event.getLanguage(),
                templateContent,
                Map.of("klnowledge", event.getCheckContent().value())
        );

        createNotificationApi.execute(createNotificationCommand);
    }
}
