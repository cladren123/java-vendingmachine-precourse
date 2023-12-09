package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

  @Test
  @DisplayName("생성자 검사 - 유효한 검사")
  void product_valid() {
    // given
    String name = "콜라";
    int cost = 1500;
    int quantitiy = 20;

    // when
    assertDoesNotThrow(() -> new Product(name, cost, quantitiy));
  }

  @Test
  @DisplayName("생성자 검사 - 가격 음수")
  void product_minus_number() {
    // given
    String name = "콜라";
    int cost = -1500;
    int quantitiy = 20;

    // when
    assertThrows(IllegalArgumentException.class, () -> new Product(name, cost, quantitiy));
  }

  @Test
  @DisplayName("생성자 검사 - 수량 음수")
  void product_minus_quantity() {
    // given
    String name = "콜라";
    int cost = 1500;
    int quantitiy = -20;

    // when
    assertThrows(IllegalArgumentException.class, () -> new Product(name, cost, quantitiy));
  }

  @Test
  @DisplayName("물건 구매 후 잔돈 반환 - 유효한 입력")
  void buy_valid_input() {
    // given
    Product product = new Product("콜라", 1500, 20);
    int money = 2000;

    // when
    int resultChange = product.buy(money);

    // then
    int expectChange = 500;
    assertEquals(expectChange, resultChange);
  }

  @Test
  @DisplayName("물건 구매 후 잔돈 반환 - 부족한 금액 입력")
  void buy_not_enough_money() {
    // given
    Product product = new Product("콜라", 1500, 20);
    int money = 1000;

    // when, then
    assertThrows(IllegalArgumentException.class, () -> {
      product.buy(money);
    });
  }

  @Test
  @DisplayName("물건 구매 후 수량 확인 - 넉넉한 경우")
  void buy_enough_quantity() {
    // given
    Product product = new Product("콜라", 1500, 2);
    int money = 2000;

    // when
    int resultChange = product.buy(money);

    // then
    assertTrue(product.hasQuantity());
  }

  @Test
  @DisplayName("물건 구매 후 수량 확인 - 수량이 없는 경우")
  void buy_zero_quantity() {
    // given
    Product product = new Product("콜라", 1500, 1);
    int money = 2000;

    // when
    int resultChange = product.buy(money);

    // then
    assertFalse(product.hasQuantity());
  }



  @Test
  @DisplayName("구매 가능 확인 - 넉넉한 금액")
  void canBuy_enough_money() {
    // given
    Product product = new Product("콜라", 1500, 1);
    int money = 2000;

    // then
    assertTrue(product.canBuy(money));
  }

  @Test
  @DisplayName("구매 가능 확인 - 부족한 금액")
  void canBuy() {
    // given
    Product product = new Product("콜라", 1500, 1);
    int money = 1000;

    // then
    assertFalse(product.canBuy(money));
  }

  @Test
  @DisplayName("여유 수량 확인 - 넉넉한 수량")
  void hasQuantity_enough_quantity() {
    // given
    Product product = new Product("콜라", 1500, 1);

    // then
    assertTrue(product.hasQuantity());
  }

  @Test
  @DisplayName("여유 수량 확인 - 부족한 수량")
  void hasQuantity_zero_quantity() {
    // given
    Product product = new Product("콜라", 1500, 0);

    // then
    assertFalse(product.hasQuantity());
  }

  @Test
  @DisplayName("이름 동일 여부 확인 - 같은 이름")
  void sameName_same_name() {
    // given
    Product product = new Product("콜라", 1500, 0);
    String name = "콜라";

    // then
    assertTrue(product.sameName(name));
  }

  @Test
  @DisplayName("이름 동일 여부 확인 - 다른 이름")
  void sameName_different_name() {
    // given
    Product product = new Product("콜라", 1500, 0);
    String name = "사이다";

    // then
    assertFalse(product.sameName(name));
  }

}