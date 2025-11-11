package ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateModel;
import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.data.MessageTemplateData;

@Mapper(componentModel = "cdi")
public interface MessageTemplateMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = ".", target = "title", qualifiedByName = "getTitleFromMessageContent")
    @Mapping(source = ".", target = "content", qualifiedByName = "getContentFromMessageContent")
    MessageTemplateData messageTemplateModelToMessageTemplateData(MessageTemplateModel model);

    @Named("getTitleFromMessageContent")
    default String getTitleFromMessageContent(MessageTemplateModel model) {
        return model.getContent().title();
    }

    @Named("getContentFromMessageContent")
    default String getContentFromMessageContent(MessageTemplateModel model) {
        return model.getContent().content();
    }
}