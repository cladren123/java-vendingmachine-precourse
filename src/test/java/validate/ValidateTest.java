package validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

  @ParameterizedTest
  @ValueSource(strings = {"999", "-10", "0"})
  @DisplayName("숫자인지 검증 - 숫자 입력")
  void validateNumber_number(String input) {
    assertDoesNotThrow(() -> Validate.validateNumber(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"abc", "10c", "??"})
  @DisplayName("숫자인지 검증 - 숫자가 아닌 입력")
  void validateNumber_not_number(String input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validateNumber(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {999, 10, 0})
  @DisplayName("양수인지 검증 - 양수 입력")
  void validatePositiveNumber_positive_number(int input) {
    assertDoesNotThrow(() -> Validate.validatePositiveNumber(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {-999, -1})
  @DisplayName("양수인지 검증 - 음수 입력")
  void validatePositiveNumber_negative_number(int input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validatePositiveNumber(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 10, 450})
  @DisplayName("10단위로 나누어 지는지 검증 - 10의 배수 입력")
  void validateDivisibleByTen_10_number(int input) {
    assertDoesNotThrow(() -> Validate.validateDivisibleByTen(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {1001, 15, 453, 9})
  @DisplayName("10단위로 나누어 지는지 검증 - 10의 배수 입력")
  void validateDivisibleByTen_not_10_number(int input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validateDivisibleByTen(input));
  }

  @Test
  @DisplayName("[]로 감싸져 있는지 검증 - 있는 경우")
  void validateBracket_valid() {
    // when
    String input = "[item, 1500, 20]";

    // then
    assertDoesNotThrow(() -> Validate.validateBracket(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"item,15,20", "[item,15,20", "item,20,15]"})
  @DisplayName("[]로 감싸져 있는지 검증 - 없는 경우 ")
  void validateBracket_invalid(String input) {
    assertThrows(IllegalArgumentException.class, () -> Validate.validateBracket(input));
  }

  @Test
  @DisplayName("아이템 형식 검증 -  3개인 경우")
  void validateItemNumber_three() {
    // given
    List<String> input = Arrays.asList(
            new String("콜라"),
            new String("1500"),
            new String("20")
    );

    // when
    assertDoesNotThrow(() -> Validate.validateItemNumber(input));
  }

  @ParameterizedTest
  @MethodSource("stringListProvider")
  @DisplayName("아이템 형식 검증 -  3개가 아닌 경우")
  void validateItemNumber_not_three(List<String> input) {
      assertThrows(IllegalArgumentException.class, () -> Validate.validateItemNumber(input));
  }

  // @MethodSource를 사용할 땐, static을 사용해야 한다. 정적 메소드만 사용할 수 있기 때문입니다.
  static Stream<List<String>> stringListProvider() {
    return Stream.of(
            Arrays.asList("콜라"),
            Arrays.asList("콜라", "1500")
    );
  }


}