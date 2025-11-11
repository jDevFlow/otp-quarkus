package ru.jdevflow.otp.domain.notification.model;

import ru.jdevflow.otp.domain.notification.commands.CreateNotificationCommand;
import java.util.UUID;
import java.util.function.Supplier;

public interface NotificationFactory {

    Notification create(Supplier<UUID> generatorId, CreateNotificationCommand command);
}
