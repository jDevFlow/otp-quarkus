package ru.jdevflow.otp.application.configuration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import ru.jdevflow.otp.domain.message.template.model.DefaultMessageTemplateFactory;
import ru.jdevflow.otp.domain.message.template.model.MessageTemplateFactory;
import ru.jdevflow.otp.domain.otp.model.DefaultOtpFactory;
import ru.jdevflow.otp.domain.otp.model.OtpFactory;

@ApplicationScoped
public class DomainConfig {

    @Produces
    OtpFactory otpFactory() {
        return new DefaultOtpFactory();
    }

    @Produces
    MessageTemplateFactory messageTemplateFactory() {
        return new DefaultMessageTemplateFactory();
    }

}
