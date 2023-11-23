package validate;

import constant.ErrorMessage;

/**
 * 검증 작업
 */
public class Validate {

  // 숫자인지 확인한다.
  public static void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
    }
  }

}
