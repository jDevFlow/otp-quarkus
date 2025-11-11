package ru.jdevflow.otp.infrastructure.otp.gateway.inmemory;

import org.mapstruct.Mapper;
import ru.jdevflow.otp.domain.otp.model.OtpModel;
import ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.data.OtpData;

@Mapper(componentModel = "cdi")
public interface OtpDataMapper {

    OtpData otpModelToOtpData(OtpModel otpModel);

}
