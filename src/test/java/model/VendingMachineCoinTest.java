package model;

import constant.Coin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineCoinTest {



  @Test
  @DisplayName("잔돈에 따른 동전 반환")
  void changeCoins() {
    // given
    Map<Coin, Integer> coins = new LinkedHashMap<>();
    coins.put(Coin.COIN_500, 2);
    coins.put(Coin.COIN_100, 3);
    coins.put(Coin.COIN_50, 3);
    coins.put(Coin.COIN_10, 3);

    VendingMachineCoin vendingMachineCoin = new VendingMachineCoin(coins);
    int money = 700;

    // when
    Map<Coin, Integer> result = vendingMachineCoin.changeCoins(money);

    // then
    Map<Coin, Integer> expect = new LinkedHashMap<>();
    expect.put(Coin.COIN_500, 1);
    expect.put(Coin.COIN_100, 2);

    assertEquals(result, expect);
  }
}