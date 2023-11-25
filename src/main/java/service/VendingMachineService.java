package service;

import constant.Coin;
import converter.Converter;
import model.VendingMachineCoin;
import validate.Validate;

import java.util.Map;

/**
 * 자판기 로직 구현
 */
public class VendingMachineService {


  // 금액을 입력하면 자판기가 보유한 동전으로 변환
  public static VendingMachineCoin inputVendingMachineMoney(String input) {
    Validate.validateNumber(input);
    Integer money = Converter.inputToMoney(input);
    Validate.validatePositiveNumber(money);
    Validate.validateDivisibleByTen(money);
    Map<Coin, Integer> coins = Coin.calculateCoint(money);
    return new VendingMachineCoin(coins);
  }

  // 현재 보유한 동전 반환
  public Map<Coin, Integer> getVendingMachineCoins(VendingMachineCoin vendingMachineCoin) {
    return vendingMachineCoin.getCoins();
  }






}
