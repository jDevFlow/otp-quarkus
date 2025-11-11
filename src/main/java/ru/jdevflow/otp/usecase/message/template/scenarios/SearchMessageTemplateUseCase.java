package ru.jdevflow.otp.usecase.message.template.scenarios;

import ru.jdevflow.otp.usecase.message.template.SearchMessageTemplateApi;
import ru.jdevflow.otp.usecase.message.template.gateway.MessageTemplateGateway;
import ru.jdevflow.otp.usecase.message.template.providers.AccountIdProvider;
import ru.jdevflow.otp.usecase.message.template.query.MessageTemplateSearch;
import ru.jdevflow.otp.usecase.message.template.query.SearchCondition;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateViewModel;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchMessageTemplateUseCase implements SearchMessageTemplateApi {

    private final MessageTemplateGateway gateway;
    private final AccountIdProvider accountIdProvider;

    @Override
    public void execute(MessageTemplateSearch messageTemplateSearch) {
        SearchCondition searchCondition = new SearchCondition(
                        "accountId",
                        "eq",
                        accountIdProvider.invoke());

        Arrays.stream(MessageTemplateViewModel.Fields.values()).forEach(field -> {

            messageTemplateSearch.getFilter().get(field.name()).stream()
                    .forEach();
        });

        messageTemplateSearch.getSearchConditions().add(searchCondition);
        gateway.search(messageTemplateSearch);
    }
}
