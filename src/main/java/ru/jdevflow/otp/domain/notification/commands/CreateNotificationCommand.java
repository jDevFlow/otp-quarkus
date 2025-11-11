package ru.jdevflow.otp.domain.notification.commands;

import java.util.Map;

public record CreateNotificationCommand(
        String channel,
        String to,

        String language,

        String templateContent,
        Map<String, String> data) {
}
