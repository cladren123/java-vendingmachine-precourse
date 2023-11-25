package converter;

import constant.Delimiter;
import constant.NumberConstant;
import validate.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 변환 작업을 처리하는 클래스
 * 유틸 성격이므로 static 사용
 */

public class Converter {



  // input을 money에 맞는지 변환
  public static Integer inputToMoney(String input) {
    return Integer.parseInt(input);
  }

  // String을 아이템 단위로 나눔 (;)
  public static List<String> inputSplitItemDelimiter(String input) {
    return new ArrayList<>(Arrays.asList(input.split(Delimiter.ITEM_SEPARATOR.getSymbol())));
  }

  // String의 앞 [ 와 뒤 ] 을 제거
  public static String inputSubstring(String input) {
    int location = NumberConstant.ITEM_LOCATION.getNumber();
    return input.substring(location, input.length() - location);
  }


  // String을 세부 단위로 나눔 (,)
  public static List<String> inputSplitDetailDelimiter(String input) {
    return new ArrayList<>(Arrays.asList(input.split(Delimiter.DETAIL_SEPARATOR.getSymbol())));
  }





}
