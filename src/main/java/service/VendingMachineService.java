package service;

import constant.Coin;
import converter.Converter;
import model.Product;
import model.VendingMachine;
import model.VendingMachineCoin;
import validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 자판기 로직 구현
 */
public class VendingMachineService {


  // 금액을 입력하면 자판기가 보유한 동전으로 변환
  public static VendingMachineCoin inputVendingMachineMoney(String input) {
    Validate.validateNumber(input);
    Integer money = Converter.stringToInteger(input);
    Validate.validatePositiveNumber(money);
    Validate.validateDivisibleByTen(money);
    Map<Coin, Integer> coins = Coin.calculateCoint(money);
    return new VendingMachineCoin(coins);
  }

  // 현재 보유한 동전 반환
  public Map<Coin, Integer> getVendingMachineCoins(VendingMachineCoin vendingMachineCoin) {
    return vendingMachineCoin.getCoins();
  }

  // 상품 입력
  public VendingMachine inputProducts(String input) {
    List<Product> products = new ArrayList<>();
    List<String> items = Converter.inputSplitItemDelimiter(input);
    for(String item : items) {
      Validate.validateBracket(item);
      String substringItem = Converter.inputSubstring(item);
      List<String> product = Converter.inputSplitDetailDelimiter(substringItem);
      products.add(listToProduct(product));
    }
    return new VendingMachine(products);
  }

  // List<String>을 Product로 변환
  public Product listToProduct(List<String> product) {
    Validate.validateItemNumber(product);
    Validate.validateNumber(product.get(1));
    Validate.validateNumber(product.get(2));

    return new Product(product.get(0),
            Integer.parseInt(product.get(1)),
            Integer.parseInt(product.get(2)));
  }

  // 투입 금액 변환
  public int inputCustomerMoney(String input) {
    Validate.validateNumber(input);
    int customerMoney = Converter.stringToInteger(input);
    Validate.validatePositiveNumber(customerMoney);
    return customerMoney;
  }

  // 물건 구매 가능 여부 확인
  public boolean canBuyProduct(VendingMachine vendingMachine, int customerMoney) {
    return vendingMachine.checkStatus(customerMoney);
  }

  // 물건 구매 : 남은 돈 반환
  public int buyProduct(VendingMachine vendingMachine, int customerMoney, String name) {
    return vendingMachine.buy(name, customerMoney);
  }

  // 잔액 동전 반환
  public Map<Coin, Integer> customerMoneyAsCoin(VendingMachineCoin vendingMachineCoin, int customerMoney) {
    return vendingMachineCoin.changeCoins(customerMoney);
  }









}
