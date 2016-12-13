package org.amdocs.tsuzammen.commons.datatypes;

public class SessionContext {
  private UserInfo user;
  private String tenant;

  public UserInfo getUser() {
    return user;
  }

  public void setUser(UserInfo user) {
    this.user = user;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }
}
