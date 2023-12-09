package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

  @Test
  @DisplayName("문자열 숫자 변환")
  void stringToInteger() {
    // given
    String input = "5";

    // when
    Integer result = Converter.stringToInteger(input);

    // then
    Integer expect = 5;
    assertEquals(expect, result);
  }

  @Test
  @DisplayName("구분자 ;로 나누기 - 여러 개 나누기")
  void inputSplitItemDelimiter_many_input() {
    // given
    String input = "[item1];[item2]";

    // when
    List<String> result = Converter.inputSplitItemDelimiter(input);

    // then
    List<String> expect = Arrays.asList("[item1]", "[item2]");
    assertEquals(expect, result);
  }

  @Test
  @DisplayName("구분자 ;로 나누기 - 한 개 나누기")
  void inputSplitItemDelimiter_one_input() {
    // given
    String input = "[item1]";

    // when
    List<String> result = Converter.inputSplitItemDelimiter(input);

    // then
    List<String> expect = Arrays.asList("[item1]");
    assertEquals(expect, result);
  }

  @Test
  @DisplayName("앞뒤의 문자 제거")
  void inputSubstring() {
    // given
    String input = "[item]";

    // when
    String result = Converter.inputSubstring(input);

    // then
    String expect = "item";
    assertEquals(expect, result);
  }

  @Test
  @DisplayName("구분자 ,로 나누기 - 여러 개 입력")
  void inputSplitDetailDelimiter_many_input() {
    // given
    String input = "name,1500,20";

    // when
    List<String> result = Converter.inputSplitDetailDelimiter(input);

    // then
    List<String> expect = Arrays.asList("name", "1500", "20");
    assertEquals(expect, result);
  }

  @Test
  @DisplayName("구분자 ,로 나누기 - 하나 입력")
  void inputSplitDetailDelimiter_one_input() {
    // given
    String input = "name";

    // when
    List<String> result = Converter.inputSplitDetailDelimiter(input);

    // then
    List<String> expect = Arrays.asList("name");
    assertEquals(expect, result);
  }
}