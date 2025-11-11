package ru.jdevflow.otp.usecase.message.template.query;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class MessageTemplateSearch {

    private Map<String, List<FieldPredicate>> filter;

}
