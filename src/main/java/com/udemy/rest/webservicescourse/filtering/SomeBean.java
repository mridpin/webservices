package com.udemy.rest.webservicescourse.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"value1", "valaue2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {


    private String value1;
    private String valaue2;
//    @JsonIgnore
    private String val3;

    public SomeBean(String value1, String valaue2, String val3) {
        this.value1 = value1;
        this.valaue2 = valaue2;
        this.val3 = val3;
    }


    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValaue2() {
        return valaue2;
    }

    public void setValaue2(String valaue2) {
        this.valaue2 = valaue2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }
}
