package model;

import constant.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class VendingMachine {

  private final List<Product> products;

  public VendingMachine(List<Product> products) {
    Collections.sort(products);
    this.products = products;
  }

  // 현재 금액이 최저 금액보다 높고 살 상품이 있는지 확인
  public boolean checkStatus(int money) {
    return checkMoney(money) && checkQuantity();
  }

  // 현재 금액으로 살 수 있는 가격의 상품이 있는지 확인
  // 최저 가격은 정해져 있는 값이므로 정렬을 통해 인덱스 0으로 배치하여 추가적인 연산 없이 결과값을 얻게 했습니다.
  public boolean checkMoney(int money) {
    return products.get(0).canBuy(money);
  }

  // 구매 할 상품이 있는지 수량 확인
  public boolean checkQuantity() {
    return products.stream()
            .anyMatch(Product::hasQuantity);
  }

  // 물건 구매
  public int buy(String name, int money) {
    return products.stream()
            .filter(product -> product.sameName(name))
            .findFirst()
            .map(product -> product.buy(money))
            .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.PRODUCT_NONE.getMessage()));
  }



}
