package constant;

public enum OutputMessage {

  VENDING_MACHINE_COIN("자판기가 보유한 동전"),
  VENDING_MACHINE_COIN_FORMAT("%d원 - %d개"),
  CHANGES("잔돈");

  private final String message;

  OutputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
