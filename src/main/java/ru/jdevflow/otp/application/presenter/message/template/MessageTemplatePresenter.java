package ru.jdevflow.otp.application.presenter.message.template;

import ru.jdevflow.otp.domain.message.template.model.MessageTemplate;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateView;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateViewModel;

public class MessageTemplatePresenter implements MessageTemplateView {

    private MessageTemplateViewModel viewModel;
    @Override
    public MessageTemplateViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(MessageTemplate messageTemplate) {
         viewModel = new MessageTemplateViewModel(
                messageTemplate.getId(),
                messageTemplate.getMetaData().accountId(),
                messageTemplate.getMetaData().applicationId(),
                messageTemplate.getMetaData().flowType(),
                messageTemplate.getMetaData().language(),
                messageTemplate.getContent().title(),
                messageTemplate.getContent().content());
    }
}
