package converter;

import validate.Validate;

public class Converter {

  // input을 money에 맞는지 변환
  public static Integer inputToMoney(String input) {
    Validate.validateNumber(input);
    int money = Integer.parseInt(input);
    Validate.validatePositiveNumber(money);
    Validate.validateDivisibleByTen(money);
    return money;
  }
}
