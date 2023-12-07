package view;

import camp.nextstep.edu.missionutils.Console;
import constant.InputMessage;

/**
 * 입력 화면은 생성합니다.
 */
public class InputView {

  // 자판기가 보유한 금액을 입력 받습니다.
  public static String inputVendingMachineMoney() {
    System.out.println(InputMessage.VENDING_MACHINE_MONEY.getMessage());
    String input = Console.readLine().trim();
    System.out.println();
    return input;
  }

  // 상품 입력 받습니다.
  public static String inputProduct() {
    System.out.println(InputMessage.PRODUCT.getMessage());
    String input = Console.readLine().trim();
    System.out.println();
    return input;
  }

  // 투입 금액 입력 받습니다.
  public static String inputCustomerMoney() {
    System.out.println(InputMessage.CUSTOMER_MONEY.getMessage());
    String input = Console.readLine().trim();
    System.out.println();
    return input;
  }

  // 구매할 상품명 입력 받습니다.
  public static String inputBuyProduct() {
    System.out.println(InputMessage.BUY_PRODUCT.getMessage());
    String input = Console.readLine().trim();
    System.out.println();
    return input;
  }

}
