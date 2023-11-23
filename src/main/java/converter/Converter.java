package converter;

import validate.Validate;

public class Converter {

  // String을 Integer로 변환
  public static Integer StringToNumber(String input) {
    Validate.validateNumber(input);
    return Integer.parseInt(input);
  }
}
