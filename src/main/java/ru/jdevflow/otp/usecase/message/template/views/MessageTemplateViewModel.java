package ru.jdevflow.otp.usecase.message.template.views;

import java.util.UUID;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(asEnum = true)
public record MessageTemplateViewModel(
        UUID id,
        String accountId,
        String applicationId,
        String flowType,
        String language,
        String title,
        String content) { }
