package ru.jdevflow.otp.application.configuration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import ru.jdevflow.otp.domain.otp.model.OtpFactory;
import ru.jdevflow.otp.infrastructure.message.template.gateway.MessageTemplateDsGateway;
import ru.jdevflow.otp.infrastructure.message.template.gateway.MessageTemplateRepository;
import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.InMemoryMessageTemplateRepository;
import ru.jdevflow.otp.infrastructure.message.template.gateway.inmemory.MessageTemplateMapper;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.InMemoryOtpRepository;
import ru.jdevflow.otp.infrastructure.otp.gateway.OtpDsGateway;
import ru.jdevflow.otp.infrastructure.otp.gateway.OtpRepository;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.OtpDataMapper;
import ru.jdevflow.otp.usecase.message.template.gateway.MessageTemplateGateway;
import ru.jdevflow.otp.usecase.otp.gateway.OtpGateway;

@ApplicationScoped
public class InfrastructureConfig {

    @Produces
    @ApplicationScoped
    OtpRepository otpRepository() {
        return new InMemoryOtpRepository();
    }

    @Produces
    OtpGateway otpGateway(OtpRepository otpRepository,
                          OtpDataMapper otpDataMapper,
                          OtpFactory otpFactory) {
        return new OtpDsGateway(otpRepository, otpDataMapper, otpFactory);
    }

    @Produces
    @ApplicationScoped
    MessageTemplateRepository messageTemplateRepository() {
        return new InMemoryMessageTemplateRepository();
    }

    @Produces
    MessageTemplateGateway messageTemplateGateway(
            MessageTemplateRepository messageTemplateRepository,
            MessageTemplateMapper messageTemplateMapper) {
        return new MessageTemplateDsGateway(messageTemplateRepository, messageTemplateMapper);
    }
}
