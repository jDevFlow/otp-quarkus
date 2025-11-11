package ru.jdevflow.otp.infrastructure.message.template.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.jdevflow.otp.infrastructure.message.template.rest.dto.CreateMessageTemplateRequest;
import ru.jdevflow.otp.infrastructure.message.template.rest.dto.MessageTemplateResponse;
import ru.jdevflow.otp.infrastructure.message.template.rest.dto.SearchMessageTemplateRequest;
import ru.jdevflow.otp.usecase.message.template.CreateMessageTemplateApi;
import ru.jdevflow.otp.usecase.message.template.SearchMessageTemplateApi;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateView;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Path("/message-template")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class MessageTemplateResource {

    private final CreateMessageTemplateApi createMessageTemplateApi;
    private final SearchMessageTemplateApi searchMessageTemplateApi;
    private final MessageTemplateView presenter;

    @POST
    public MessageTemplateResponse create(CreateMessageTemplateRequest request) {
        createMessageTemplateApi.execute(request.toCommand(), presenter);
        return MessageTemplateResponse.from(presenter.getViewModel());
    }

    @POST
    @Path("/search")
    public List<MessageTemplateResponse> create(SearchMessageTemplateRequest request) {
        searchMessageTemplateApi.execute(request.toCommand(), presenter);
        return MessageTemplateResponse.from(presenter.getViewModel());
    }
}
