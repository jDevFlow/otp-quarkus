package ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory;

import ru.jdevflow.otp.infrastructure.message.template.gateway.MessageTemplateRepository;
import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.data.MessageTemplateData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InMemoryMessageTemplateRepository implements MessageTemplateRepository {

    private final Map<String, MessageTemplateData> store = new ConcurrentHashMap<>();

    @Override
    public void save(MessageTemplateData messageTemplateData) {
        this.store.put(messageTemplateData.getId().toString(), messageTemplateData);
    }

    @Override
    public MessageTemplateData search(String filter) {
        return store.values().stream()
                .filter(messageTemplateData -> messageTemplateData.getFlowType().equals(filter))
                .findFirst().orElse(null);
    }
}
