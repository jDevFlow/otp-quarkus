package ru.jdevflow.otp.application.configuration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import ru.jdevflow.otp.application.presenter.message.template.MessageTemplatePresenter;
import ru.jdevflow.otp.application.presenter.otp.CheckOtpResultPresenter;
import ru.jdevflow.otp.application.presenter.otp.OtpIdPresenter;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateFactory;
import ru.jdevflow.otp.domain.otp.model.OtpFactory;
import ru.jdevflow.otp.usecase.message.template.CreateMessageTemplateApi;
import ru.jdevflow.otp.usecase.message.template.gateway.MessageTemplateGateway;
import ru.jdevflow.otp.usecase.message.template.providers.AccountIdProvider;
import ru.jdevflow.otp.usecase.message.template.scenarios.CreateMessageTemplateUseCase;
import ru.jdevflow.otp.usecase.message.template.views.MessageTemplateView;
import ru.jdevflow.otp.usecase.otp.CheckOtpApi;
import ru.jdevflow.otp.usecase.otp.CreateOtpApi;
import ru.jdevflow.otp.usecase.otp.gateway.OtpGateway;
import ru.jdevflow.otp.usecase.otp.scenarios.CheckOtpUseCase;
import ru.jdevflow.otp.usecase.otp.scenarios.CreateOtpUseCase;
import ru.jdevflow.otp.usecase.otp.views.CheckOtpResultView;
import ru.jdevflow.otp.usecase.otp.views.OtpIdView;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

@ApplicationScoped
public class UseCaseConfig {

    @Produces
    @Named("generatorId")
    Supplier<UUID> generatorId() {
        return UUID::randomUUID;
    }

    @Produces
    @Named("generateCode")
    Supplier<String> generateCode() {
        return () -> String.valueOf(Math.random());
    }

    @Produces
    @Named("currentDateTime")
    Supplier<Instant> currentDateTime() {
        return Instant::now;
    }

    @Produces
    OtpIdView otpIdView() {
        return new OtpIdPresenter();
    }

    @Produces
    MessageTemplateView messageTemplateView() {
        return new MessageTemplatePresenter();
    }

    @Produces
    CheckOtpResultView checkOtpResultView() {
        return new CheckOtpResultPresenter();
    }

    @Produces
    CreateOtpApi createOtpApi(@Named("generatorId") Supplier<UUID> generatorId,
                              @Named("generateCode") Supplier<String> generateCode,
                              @Named("currentDateTime") Supplier<Instant> currentDateTime,
                              OtpFactory otpFactory, OtpGateway otpGateway) {
        return new CreateOtpUseCase(generatorId, generateCode, currentDateTime,
                otpFactory, otpGateway);
    }

    @Produces
    CheckOtpApi checkOtpApi(OtpGateway otpGateway,
                            @Named("currentDateTime") Supplier<Instant> currentDateTime) {
        return new CheckOtpUseCase(otpGateway, currentDateTime);
    }

    @Produces
    AccountIdProvider accountIdProvider() {
        return () -> "00000000-00000000-00000000-00000000";
    }

    @Produces
    CreateMessageTemplateApi createMessageTemplateApi(
            @Named("generatorId") Supplier<UUID> generatorId,
            AccountIdProvider accountIdProvider,
            MessageTemplateFactory messageTemplateFactory,
            MessageTemplateGateway messageTemplateGateway) {

        return new CreateMessageTemplateUseCase(
                generatorId,
                accountIdProvider,
                messageTemplateFactory,
                messageTemplateGateway);
    }

}
