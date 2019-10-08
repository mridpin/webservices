package com.udemy.rest.webservicescourse.theEmperor;

public class PraiseTheEmperorBean {

  private String message;

  public PraiseTheEmperorBean(String praiseTheEmperor) {
    this.message = praiseTheEmperor;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "PraiseTheEmperorBean{" +
        "message='" + message + '\'' +
        '}';
  }
}
