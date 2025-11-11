package ru.jdevflow.otp.infrastructure.message.template.rest.dto;

import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateViewModel;
import java.util.UUID;

public record MessageTemplateResponse(UUID id,
                                      String accountId,
                                      String applicationId,
                                      String flowType,
                                      String language,
                                      String title,
                                      String content) {

    public static MessageTemplateResponse from(MessageTemplateViewModel viewModel) {
        return new MessageTemplateResponse(
                viewModel.id(),
                viewModel.accountId(),
                viewModel.applicationId(),
                viewModel.flowType(),
                viewModel.language(),
                viewModel.title(),
                viewModel.content());
    }

}
