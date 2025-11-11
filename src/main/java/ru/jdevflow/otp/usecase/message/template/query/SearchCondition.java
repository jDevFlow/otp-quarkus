package ru.jdevflow.otp.usecase.message.template.query;

public class SearchCondition {

    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption; //ALL ANY

    public SearchCondition(String filterKey, String operation, Object value){
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }
}
