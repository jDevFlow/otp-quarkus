package ru.jdevflow.otp.usecase.notification.providers;

/**
 * Провайдер обеспечивает шаблоном уведомление.
 */
public interface TemplateContentProvider {

    /**
     * Запрос данных из другой модели.
     *
     * @param applicationId идентификатора приложения
     * @param flowType      тип потока данных для приложения
     * @param language      язык шаблона
     * @return String шаблон
     */
    String invoke(String applicationId, String flowType, String language);

}
