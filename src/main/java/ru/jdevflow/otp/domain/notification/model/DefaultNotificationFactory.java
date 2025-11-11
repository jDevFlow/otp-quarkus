package ru.jdevflow.otp.domain.notification.model;

import ru.jdevflow.otp.domain.notification.commands.CreateNotificationCommand;
import java.util.UUID;
import java.util.function.Supplier;

public class DefaultNotificationFactory implements NotificationFactory {

    @Override
    public Notification create(Supplier<UUID> generatorId,
                               CreateNotificationCommand command) {


        return null;
    }
}
