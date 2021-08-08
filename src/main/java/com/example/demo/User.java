package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
  @EmbeddedId
  private UserPk userPk;

  @Column(name="userID")
  private String userId;

  public User() {}

  public User(UserPk userPk, String userId) {
    this.userPk = userPk;
    this.userId = userId;
  }

  public UserPk getUserPk() {
    return userPk;
  }

  public void setUserPk(UserPk userPk) {
    this.userPk = userPk;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}