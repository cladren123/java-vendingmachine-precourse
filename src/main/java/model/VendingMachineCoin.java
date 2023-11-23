package model;

import constant.Coin;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 자판기가 보유한 금액
 */
public class VendingMachineCoin {

  private final Map<Coin, Integer> coins;

  public VendingMachineCoin(Map<Coin, Integer> coins) {
    this.coins = coins;
  }

  // 잔돈에 따른 동전 반환
  public Map<Coin, Integer> changeCoin(int money) {
    Map<Coin, Integer> change = new LinkedHashMap<>();
    for (Coin coin : Coin.values()) {
      Integer availableCoins = coins.get(coin);
      int needCoin = Math.min(availableCoins, money / coin.getAmount());
      if(needCoin > 0) {
        change.put(coin, needCoin);
        money -= needCoin * coin.getAmount();
      }
    }
    return change;
  }










}
