package ru.jdevflow.otp.infrastructure.otp.gateway.inmemory.data;

import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtpData {

    private UUID id;
    private Long version;
    private SendDirection sendDirection;
    private ApplicationId applicationId;
    private String flowType;
    private String audienceId;
    private String language;
    private CheckContent checkContent;
    private Instant expiryDate;
    private Instant generateAt;
    private Instant lastAttemptAt;
    private Integer countAttempt;
    private BehaviorOtp behaviorOtp;
}
