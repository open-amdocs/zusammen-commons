package org.amdocs.tsuzammen.utils.facade.impl;

public abstract class AbstractContextFactory<I, C> extends AbstractFactoryBase {
  public abstract I createInterface(C contextType);
}
