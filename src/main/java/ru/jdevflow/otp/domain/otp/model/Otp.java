package ru.jdevflow.otp.domain.otp.model;

import ru.jdevflow.otp.domain.otp.model.vo.ApplicationId;
import ru.jdevflow.otp.domain.otp.model.vo.BehaviorOtp;
import ru.jdevflow.otp.domain.otp.model.vo.CheckContent;
import ru.jdevflow.otp.domain.otp.model.vo.SendDirection;
import java.time.Instant;
import java.util.UUID;

/**
 * OTP - One Time Password (одноразовый пароль).
 */
public interface Otp {

    /**
     * Уникальный идентификатор запроса для OTP
     *
     * @return UUID
     */
    UUID getId();

    /**
     * Канал отправки OTP
     *
     * @return SendDirection
     */
    SendDirection getSendDirection();

    /**
     * Идентификатор приложения которое использует OTP
     *
     * @return идентификатор приложения
     */
    ApplicationId getApplicationId();

    /**
     * Направление в котором используется OTP
     *
     * @return String
     */
    String getFlowType();

    /**
     * Для кого сформирован запрос.
     * Идентификатор формируемый приложением в рамках которого можно устанавливать ограничения.
     *
     * @return String
     */
    String getAudienceId();

    /**
     * Язык выбора шаблона сообщения
     *
     * @return String
     */
    String getLanguage();

    /**
     * Контекст знаний передаваемых в рамках OTP. Возможна генерация средствами сервиса, либо
     * передаётся статично от приложения.
     *
     * @return CheckContent
     */
    CheckContent getCheckContent();

    /**
     * Время генерации запроса OTP.
     *
     * @return Instant
     */
    Instant getGenerateAt();

    /**
     * Время когда OTP запрос станет не актуальным.
     *
     * @return Instant
     */
    Instant getExpiryDate();

    /**
     * Время последней попытки
     *
     * @return Instant
     */
    Instant getLastAttemptAt();

    /**
     * Количество попыток угадать OTP
     *
     * @return Integer
     */
    Integer getCountAttempt();

    /**
     * Поведение OTP после действий пользователя
     *
     * @return BehaviorOtp
     */
    BehaviorOtp getBehaviorOtp();

}
