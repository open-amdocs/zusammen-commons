package org.amdocs.tsuzammen.utils.fileutils;

import org.apache.commons.collections4.MapUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileContentHandler {
  private Map<String, byte[]> files = new HashMap<>();

  public InputStream getFileContent(String fileName) {
    byte[] content = files.get(fileName);
    return content == null || content.length == 0 ? null : new ByteArrayInputStream(content);
  }

  public void addFile(String fileName, byte[] contect) {
    files.put(fileName, contect);
  }

  public void addFile(String fileName, InputStream is) {

    files.put(fileName, FileUtils.toByteArray(is));
  }

  public void setFiles(FileContentHandler extFiles) {
    extFiles.getFileList().stream()
        .forEach(fileName -> this.addFile(fileName, extFiles.getFileContent(fileName)));
  }

  public Set<String> getFileList() {
    return files.keySet();
  }

  public void putAll(Map<String, byte[]> files) {
    this.files = files;
  }

  public void addAll(FileContentHandler other) {
    this.files.putAll(other.files);
  }

  public boolean isEmpty() {
    return MapUtils.isEmpty(this.files);
  }

  public void remove(String fileName) {
    files.remove(fileName);
  }

  public boolean containsFile(String fileName) {
    return files.containsKey(fileName);
  }
}
