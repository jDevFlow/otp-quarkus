package ru.jdevflow.otp.domain.message.template.model.vo;

/**
 *
 * @param accountId
 * @param applicationId
 * @param flowType
 * @param language
 */
public record MetaData(String accountId, String applicationId, String flowType, String language) {
}
