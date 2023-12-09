package controller;

import constant.Coin;
import model.VendingMachine;
import model.VendingMachineCoin;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class VendingMachineController {

  private final VendingMachineService vendingMachineService = new VendingMachineService();


  // 프로그램 시작
  public void start() {
    VendingMachineCoin vendingMachineCoin = inputVendingMachineMoney();
    printVendingMachineCoin(vendingMachineCoin);
    VendingMachine vendingMachine = inputProducts();
    int customerMoney = inputCustomerMoney();
    customerMoney = inputBuyProduct(vendingMachine, customerMoney);
    printCustomerMoneyAsCoin(vendingMachineCoin, customerMoney);
  }

  // 자판기 보유 금액 입력
  public VendingMachineCoin inputVendingMachineMoney() {
    while(true) {
      try {
        String input = InputView.inputVendingMachineMoney();
        return VendingMachineService.inputVendingMachineMoney(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  // 자판기 보유 동전 출력
  public void printVendingMachineCoin(VendingMachineCoin vendingMachineCoin) {
    Map<Coin, Integer> coins = vendingMachineService.getVendingMachineCoins(vendingMachineCoin);
    OutputView.printVendingMachineCoin(coins);
  }

  // 상품 입력
  public VendingMachine inputProducts() {
    while(true) {
      try {
        String input = InputView.inputProduct();
        return vendingMachineService.inputProducts(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  // 투입 금액 입력
  public int inputCustomerMoney() {
    while(true) {
      try {
        String input = InputView.inputCustomerMoney();
        return vendingMachineService.inputCustomerMoney(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  // 물건 구매 : 잔액 반환
  public int inputBuyProduct(VendingMachine vendingMachine, int customerMoney) {
    while(vendingMachineService.canBuyProduct(vendingMachine, customerMoney)) {
      try {
        OutputView.printCustomerMoney(customerMoney);
        String name = InputView.inputBuyProduct();
        customerMoney = vendingMachineService.buyProduct(vendingMachine, customerMoney, name);
      }
      catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    return customerMoney;
  }

  // 잔돈 반환
  public void printCustomerMoneyAsCoin(VendingMachineCoin vendingMachineCoin, int customerMoney) {
    OutputView.printCustomerMoney(customerMoney);
    Map<Coin, Integer> customerMoneyAsCoin = vendingMachineService.customerMoneyAsCoin(vendingMachineCoin, customerMoney);
    OutputView.printCustomerMoneyAsCoin(customerMoneyAsCoin);
  }



}
