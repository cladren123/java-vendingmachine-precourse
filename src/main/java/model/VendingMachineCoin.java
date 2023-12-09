package model;

import constant.Coin;

import java.util.Collections;
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

  // 현재 보유한 동전 반환 - 복사본 생성 후 불변 객체로 만들어 반환
  public Map<Coin, Integer> getCoins() {
    return Collections.unmodifiableMap(new LinkedHashMap<>(coins));
  }



  // 잔돈에 따른 동전 반환
  public Map<Coin, Integer> changeCoins(int money) {
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
