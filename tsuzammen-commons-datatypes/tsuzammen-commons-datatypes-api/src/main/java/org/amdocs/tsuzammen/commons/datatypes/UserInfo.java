package org.amdocs.tsuzammen.commons.datatypes;

/**
 * Created by TALIG on 11/27/2016.
 */
public class UserInfo {

  private String userName;

  public UserInfo() {
  }

  public UserInfo(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserInfo userInfo = (UserInfo) o;

    return userName != null ? userName.equals(userInfo.userName) : userInfo.userName == null;

  }

  @Override
  public int hashCode() {
    return userName != null ? userName.hashCode() : 0;
  }
}
