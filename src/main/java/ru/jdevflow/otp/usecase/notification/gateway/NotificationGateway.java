package ru.jdevflow.otp.usecase.notification.gateway;

import ru.jdevflow.otp.domain.notification.model.NotificationModel;

public interface NotificationGateway {

    void persist(NotificationModel notification);


}
