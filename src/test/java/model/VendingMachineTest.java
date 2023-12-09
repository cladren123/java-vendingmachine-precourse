package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

  @Test
  @DisplayName("생성자 검사")
  void VendingMachine() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 2000, 20),
            new Product("사이다", 1500, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1800;

    // when
    // 정렬되었다면 1500원이 0번째 인덱스가 되서 true가 된다.
    assertTrue(vendingMachine.checkMoney(money));
  }


  @Test
  @DisplayName("물건을 살 수 있는지 확인")
  void checkStatus_sufficient_money_quantity() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 20),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1500;

    // when
    assertTrue(vendingMachine.checkStatus(money));
  }

  @Test
  @DisplayName("물건을 살 수 있는지 확인 - 부족한 금액")
  void checkStatus_insufficient_money_sufficient_quantity() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 20),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1400;

    // when
    assertFalse(vendingMachine.checkStatus(money));
  }

  @Test
  @DisplayName("물건을 살 수 있는지 확인 - 부족한 수량")
  void checkStatus_sufficient_money_insufficient_quantity() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 0),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1600;

    // when
    assertFalse(vendingMachine.checkStatus(money));
  }

  @Test
  @DisplayName("금액으로 살 수 있는 상품이 있는지 확인 - 충분한 금액")
  void checkMoney_sufficient_money() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 20),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1500;

    // when
    assertTrue(vendingMachine.checkMoney(money));
  }

  @Test
  @DisplayName("금액으로 살 수 있는 상품이 있는지 확인 - 불충분한 금액")
  void checkMoney_insufficient_money() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 20),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1000;

    // when
    assertFalse(vendingMachine.checkMoney(money));
  }

  @Test
  @DisplayName("수량 확인 - 충분한 수량")
  void checkQuantity_sufficient_quantity() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 20),
            new Product("사이다", 2000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1800;

    // when
    assertTrue(vendingMachine.checkQuantity(money));
  }

  @Test
  @DisplayName("수량 확인 - 불충분한 수량")
  void checkQuantity_insufficient_quantity() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 0),
            new Product("사이다", 2000, 0)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    int money = 1800;

    // when
    assertFalse(vendingMachine.checkQuantity(money));
  }

  @Test
  @DisplayName("물건 구매 후 잔돈 반환")
  void buy_sufficient_money() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 10),
            new Product("사이다", 1000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    String name = "콜라";
    int money = 2000;

    // when
    int result = vendingMachine.buy(name, money);

    // then
    int expect = 500;
    assertEquals(result, expect);
  }

  @Test
  @DisplayName("물건 구매 후 잔돈 반환")
  void buy_insufficient_money() {
    // given
    List<Product> products = Arrays.asList(
            new Product("콜라", 1500, 10),
            new Product("사이다", 1000, 10)
    );
    VendingMachine vendingMachine = new VendingMachine(products);
    String name = "콜라";
    int money = 1300;

    // when
    assertThrows(IllegalArgumentException.class, () -> {
      vendingMachine.buy(name, money);
    });
  }
}