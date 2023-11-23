package constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현

    // 금액이 들어오면 최소 동전 개수 반환
    public static Map<Coin, Integer> calculateCoint(int money) {
        Map<Coin, Integer> result = new LinkedHashMap<>();

        for(Coin coin : Coin.values()) {
            int count = money / coin.amount;
            money -= money * coin.amount;
            result.put(coin, count);
        }

        return result;
    }

}
