package constant;


import java.util.PrimitiveIterator;

// 숫자 관리
public enum NumberConstant {

  MONEY_UNIT(10);

  private final int number;

  NumberConstant(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;\
  }
}
