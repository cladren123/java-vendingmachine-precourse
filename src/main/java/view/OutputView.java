package view;


import constant.Coin;
import constant.OutputMessage;

import java.util.Map;

/**
 * 출력 화면 구현
 */
public class OutputView {

  // 자판기가 보유한 동전 출력
  public static void printVendingMachineCoin(Map<Coin, Integer> coins) {
    System.out.println(OutputMessage.VENDING_MACHINE_COIN.getMessage());
    for(Coin coin : coins.keySet()) {
      System.out.println(String.format(
              OutputMessage.VENDING_MACHINE_COIN_FORMAT.getMessage(), coin.getAmount(), coins.get(coin)
      ));
    }
    System.out.println();
  }

  // 현재 투입 금액 출력
  public static void printCustomerMoney(int money) {
    System.out.println(String.format(
            OutputMessage.CUSTOMER_MONEY.getMessage(), money
    ));
  }

  // 잔액 코인으로 출력
  public static void printCustomerMoneyAsCoin(Map<Coin, Integer> customerMoneyAsCoin) {
    System.out.println(OutputMessage.CHANGES.getMessage());
    for(Coin coin : customerMoneyAsCoin.keySet()) {
      System.out.println(String.format(
              OutputMessage.VENDING_MACHINE_COIN_FORMAT.getMessage(),
              coin.getAmount(),
              customerMoneyAsCoin.get(coin)
              )
      );
    }
  }


}
