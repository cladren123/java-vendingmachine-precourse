package service;

import constant.Coin;
import converter.Converter;
import model.VendingMachineCoin;

import java.util.Map;

/**
 * 자판기 로직 구현
 */
public class VendingMachineService {

  private final VendingMachineCoin vendingMachineCoin;

  public static VendingMachineCoin inputVendingMachineMoney(String input) {
    Integer money = Converter.StringToNumber(input);
    Map<Coin, Integer> coins = Coin.calculateCoint(money);
    return new VendingMachineCoin(coins);
  }

  public VendingMachineService(VendingMachineCoin vendingMachineCoin) {
    this.vendingMachineCoin = vendingMachineCoin;
  }

  // 현재 보유한 동전 반환
  public Map<Coin, Integer> getVendingMachineCoins() {
    return vendingMachineCoin.getCoins();
  }






}
