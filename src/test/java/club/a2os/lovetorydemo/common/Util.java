package club.a2os.lovetorydemo.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
