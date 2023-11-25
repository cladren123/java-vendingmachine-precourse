package validate;

import constant.ErrorMessage;
import constant.NumberConstant;

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

  // 10 단위로 나누어 떨어지는지 검증
  public static void validateDivisibleByTen(int input) {
    if(input % NumberConstant.MONEY_UNIT.getNumber() != 0) {
      throw new IllegalArgumentException(ErrorMessage.DIVISIBLE_BY_TEN.getMessage());
    }
  }



}
