package validate;

import constant.ErrorMessage;

/**
 * 검증 작업
 */
public class Validate {

  // 숫자인지 검증
  public static void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
    }
  }
  
  // 양수인지 검증
  public static void validatePositiveNumber(int input) {
    if(input < 0) {
      throw new IllegalArgumentException(ErrorMessage.POSITIVE_NUMBER.getMessage());
    }
  }



}
