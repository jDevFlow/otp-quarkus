package ru.jdevflow.otp.usecase.message.template;

import ru.jdevflow.otp.usecase.message.template.query.MessageTemplateSearch;

public interface SearchMessageTemplateApi {

    void execute(MessageTemplateSearch messageTemplateSearch);
}
