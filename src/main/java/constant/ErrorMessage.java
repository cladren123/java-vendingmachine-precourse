package constant;

public enum ErrorMessage {

  NUMBER("금액은 숫자여야 합니다."),
  POSITIVE_NUMBER("금액은 양수여야 합니다."),
  DIVISIBLE_BY_TEN("10의 단위로 떨어져야 합니다."),
  PRODUCT_FORM("[상품명,가격,수량];[상품명,가격,수량] 형식으로 입력해야 합니다."),
  PRODUCT_NONE("없는 상품명 입니다."),
  NOT_ENOUGH_MONEY("금액이 부족합니다.");


  private final String message;

  ErrorMessage(String message) {
    this.message = "[ERROR] " + message;
  }

  public String getMessage() {
    return message;
  }
}
