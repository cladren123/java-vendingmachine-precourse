package model;

import constant.ErrorMessage;
import validate.Validate;

public class Product {

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
      quantity = -1;
      return money - cost;
    }
    throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
  }


}
