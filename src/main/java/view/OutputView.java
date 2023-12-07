package view;


import constant.Coin;
import constant.OutputMessage;

import java.util.Map;

/**
 * 출력 화면 구현
 */
public class OutputView {

  // 자판기가 보유한 동전 출력
  public void printVendingMachineCoin(Map<Coin, Integer> coins) {
    System.out.println(OutputMessage.VENDING_MACHINE_COIN.getMessage());
    for(Coin coin : coins.keySet()) {
      System.out.println(String.format(
              OutputMessage.VENDING_MACHINE_COIN_FORMAT.getMessage(), coin.getAmount(), coins.get(coin)
      ));
    }
    System.out.println();
  }


}
