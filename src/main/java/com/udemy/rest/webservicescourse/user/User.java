package com.udemy.rest.webservicescourse.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ApiModel(description = "Details about user")
public class User {

  private Integer id;
  @Size(min = 2, message = "Name should have 2 characters")
  @ApiModelProperty(notes = "what updog")
  private String name;
  @Past
  @ApiModelProperty(notes = "Name should be in the pas")
  private Date birthdate;

  public User() {}

  public User(Integer id, String name, Date birthdate) {
    super();
    this.id = id;
    this.name = name;
    this.birthdate = birthdate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
}
