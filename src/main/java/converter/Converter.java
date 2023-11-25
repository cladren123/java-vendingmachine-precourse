package converter;

import validate.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {



  // input을 money에 맞는지 변환
  public static Integer inputToMoney(String input) {
    return Integer.parseInt(input);
  }

  // input을 상품명, 가격, 수량으로 구분
  public static List<String> inputToProduct(String input) {
    return new ArrayList<>(Arrays.asList(input.split(";")));
  }

  



}
