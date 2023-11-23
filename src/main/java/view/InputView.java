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
    return Console.readLine().trim();
  }

}
