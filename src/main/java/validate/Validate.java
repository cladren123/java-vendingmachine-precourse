package validate;

import constant.Delimiter;
import constant.ErrorMessage;
import constant.NumberConstant;

import java.util.List;

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

  // 아이템이 []로 감싸져 있는지 검증
  public static void validateBracket(String input) {
    if(!input.startsWith(Delimiter.ITEM_START.getSymbol()) || !input.endsWith(Delimiter.ITEM_END.getSymbol())) {
      throw new IllegalArgumentException(ErrorMessage.PRODUCT_FORM.getMessage());
    }
  }

  // 아이템이 3개로 이루어져 있는지 검증
  public static void validateItemNumber(List<String> input) {
    if(input.size() != NumberConstant.PRODUCT_FORMAT_SIZE.getNumber()) {
      throw new IllegalArgumentException(ErrorMessage.PRODUCT_FORM.getMessage());
    }
  }



}
