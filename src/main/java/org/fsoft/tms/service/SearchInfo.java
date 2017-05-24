package org.fsoft.tms.service;

/**
 * Created by DELL on 5/24/2017.
 */
public class SearchInfo {
    private String fieldName, value;

    public String getField() {
        return fieldName;
    }

    public void setField(String field) {
        this.fieldName = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SearchInfo(String field, String value) {

        this.fieldName = field;
        this.value = value;
    }
}
