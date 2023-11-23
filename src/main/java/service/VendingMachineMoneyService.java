package service;


import constant.Coin;
import converter.Converter;
import model.VendingMachineCoin;

import java.util.Map;

/**
 * 자판기 금액 관련 로직 처리
 */
public class VendingMachineMoneyService {

  public static VendingMachineCoin inputVendingMachineMoney(String input) {
    Integer money = Converter.StringToNumber(input);
    Map<Coin, Integer> coins = Coin.calculateCoint(money);
    return new VendingMachineCoin(coins);
  }


}
