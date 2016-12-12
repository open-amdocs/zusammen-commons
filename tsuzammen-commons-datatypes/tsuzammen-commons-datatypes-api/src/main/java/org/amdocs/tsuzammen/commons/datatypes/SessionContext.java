package org.amdocs.tsuzammen.commons.datatypes;

import java.util.Optional;

public class SessionContext {
  private UserInfo user;
  private Optional<String> tenant = Optional.empty();

  public UserInfo getUser() {
    return user;
  }

  public void setUser(UserInfo user) {
    this.user = user;
  }

  public Optional<String> getTenant() {
    return tenant;
  }

  public void setTenant(Optional<String> tenant) {
    this.tenant = tenant;
  }
}
