package com.udemy.rest.webservicescourse.user;

import com.udemy.rest.webservicescourse.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Details about user")
@Entity
public class User {

  @Id @GeneratedValue private Integer id;

  @Size(min = 2, message = "Name should have 2 characters")
  @ApiModelProperty(notes = "what updog")
  private String name;

  @Past
  @ApiModelProperty(notes = "Name should be in the pas")
  private Date birthdate;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;

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

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}
