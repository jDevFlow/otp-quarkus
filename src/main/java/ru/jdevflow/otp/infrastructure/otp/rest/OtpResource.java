package ru.jdevflow.otp.infrastructure.otp.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.jdevflow.otp.infrastructure.otp.rest.dto.CheckOtpRequest;
import ru.jdevflow.otp.infrastructure.otp.rest.dto.CreateOtpDtoRequest;
import ru.jdevflow.otp.infrastructure.otp.rest.dto.OtpIdDtoResponse;
import ru.jdevflow.otp.usecase.otp.CheckOtpApi;
import ru.jdevflow.otp.usecase.otp.CreateOtpApi;
import ru.jdevflow.otp.usecase.otp.views.OtpIdView;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Path("/otp")
@RequiredArgsConstructor
public class OtpResource {

    private final CreateOtpApi createOtpApi;
    private final CheckOtpApi checkOtpApi;
    private final OtpIdView otpIdPresenter;

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OtpIdDtoResponse createOpt(CreateOtpDtoRequest request) {
        createOtpApi.execute(request.toCommand(), otpIdPresenter);
        UUID otpId = otpIdPresenter.getViewModel();
        return new OtpIdDtoResponse(otpId);
    }

    @POST
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void checkOpt(CheckOtpRequest checkOtpRequest) {
        checkOtpApi.execute(checkOtpRequest.otpId(), checkOtpRequest.knowledge());
    }
}
