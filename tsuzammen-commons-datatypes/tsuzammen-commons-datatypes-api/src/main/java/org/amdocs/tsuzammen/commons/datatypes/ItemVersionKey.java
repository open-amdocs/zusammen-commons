package org.amdocs.tsuzammen.commons.datatypes;

/**
 * Created by TALIG on 11/27/2016.
 */
public class ItemVersionKey {

  private String itemId;
  private String versionId;

  public ItemVersionKey() {
  }


  public ItemVersionKey(String itemId, String versionId) {
    this.itemId = itemId;
    this.versionId = versionId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getVersionId() {
    return versionId;
  }

  public void setVersionId(String versionId) {
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
