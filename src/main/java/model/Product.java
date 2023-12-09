package model;

import constant.ErrorMessage;
import validate.Validate;

public class Product implements Comparable<Product> {

  private final String name; // 상품명
  private final int cost; // 상품 가격
  private int quantity; // 상품 수량


  public Product(String name, int cost, int quantity) {
    Validate.validatePositiveNumber(cost);
    Validate.validatePositiveNumber(quantity);

    this.name = name;
    this.cost = cost;
    this.quantity = quantity;
  }


  // 상품을 사고 남은 돈을 반환
  public int buy(int money) {
    if(money >= cost) {
      quantity -= 1;
      return money - cost;
    }
    throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
  }

  // 현재 금액으로 상품으로 구매할 수 있는지 확인
  public boolean canBuy(int money) {
    return cost <= money;
  }

  // 상품의 갯수가남았는지 확인
  public boolean hasQuantity() {
    return quantity > 0;
  }

  // 상품의 이름이 맞는지 확인
  public boolean sameName(String name) {
    return this.name.equals(name);
  }

  // 가격 오름차순
  public int compareTo(Product p) {
    return this.cost - p.cost;
  }


}
