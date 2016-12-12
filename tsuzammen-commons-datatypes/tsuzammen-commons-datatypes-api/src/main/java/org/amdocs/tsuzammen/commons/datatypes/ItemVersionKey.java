package org.amdocs.tsuzammen.commons.datatypes;

/**
 * Created by TALIG on 11/27/2016.
 */
public class ItemVersionKey {

  private Id itemId;
  private Id versionId;

  public ItemVersionKey() {
  }

  public ItemVersionKey(Id itemId, Id versionId) {
    this.itemId = itemId;
    this.versionId = versionId;
  }

  public ItemVersionKey(String itemId, String versionId) {
    this.itemId = new Id(itemId);
    this.versionId = new Id(versionId);
  }

  public Id getItemId() {
    return itemId;
  }

  public void setItemId(Id itemId) {
    this.itemId = itemId;
  }

  public Id getVersionId() {
    return versionId;
  }

  public void setVersionId(Id versionId) {
    this.versionId = versionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ItemVersionKey that = (ItemVersionKey) o;

    return (itemId != null ? itemId.equals(that.itemId) : that.itemId == null) &&
        (versionId != null ? versionId.equals(that.versionId) : that.versionId == null);

  }

  @Override
  public int hashCode() {
    int result = itemId != null ? itemId.hashCode() : 0;
    result = 31 * result + (versionId != null ? versionId.hashCode() : 0);
    return result;
  }
}
