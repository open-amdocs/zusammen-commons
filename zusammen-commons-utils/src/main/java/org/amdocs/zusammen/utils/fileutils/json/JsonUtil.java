package org.amdocs.zusammen.utils.fileutils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;


public class JsonUtil {

  public static String object2Json(Object obj) {
    return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
  }

  public static <T> T json2Object(String json, Class<T> classOfT) {
    return json2Object(json, (Type) classOfT);
  }

  public static <T> T json2Object(String json, Type typeOfT) {
    T t;
    try {
      try (Reader br = new StringReader(json)) {
        t = new Gson().fromJson(br, typeOfT);
      } catch (IOException e) {
        throw e;
      }
    } catch (JsonIOException | JsonSyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
    return t;
  }

  public static String inputStream2Json(InputStream is) {
    if (Objects.isNull(is)) {
      throw new RuntimeException("Input object is null");
    }
    Map mapObject = json2Object(is, Map.class);
    return object2Json(mapObject);
  }

  public static <T> T json2Object(InputStream is, Class<T> classOfT) {
    return json2Object(is, (Type) classOfT);
  }

  public static <T> T json2Object(InputStream is, Type typeOfT) {
    T t;
    try {
      try (Reader br = new BufferedReader(new InputStreamReader(is))) {
        t = new Gson().fromJson(br, typeOfT);
      } catch (IOException e) {
        throw e;
      }
    } catch (JsonIOException | JsonSyntaxException | IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException ignore) {
        }
      }
    }
    return t;
  }


  //todo check https://github.com/stleary/JSON-java as replacement for this code
  public static boolean isValidJson(String json) {
    try {
      return new JsonParser().parse(json).isJsonObject();
    } catch (JsonSyntaxException jse) {
      return false;
    }
  }


}
