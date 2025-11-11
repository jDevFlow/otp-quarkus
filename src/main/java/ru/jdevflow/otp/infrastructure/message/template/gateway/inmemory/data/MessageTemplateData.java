package ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.data;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageTemplateData {

    private UUID id;
    private String accountId;
    private String applicationId;
    private String flowType;
    private String language;
    private String title;
    private String content;
}
