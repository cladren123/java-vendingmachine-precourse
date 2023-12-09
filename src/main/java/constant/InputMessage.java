package constant;

public enum InputMessage {

  VENDING_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
  PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
  CUSTOMER_MONEY("투입 금액을 입력해 주세요."),
  BUY_PRODUCT("구매할 상품명을 입력해 주세요.");

  private final String message;

  InputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
