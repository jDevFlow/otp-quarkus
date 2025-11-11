package ru.jdevflow.otp.domain.message.template.model.vo;

import java.io.Serial;
import java.io.Serializable;

public record MessageContent(String title, String content) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
