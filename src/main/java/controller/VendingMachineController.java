package controller;

import constant.Coin;
import model.Product;
import model.VendingMachineCoin;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class VendingMachineController {

  private final VendingMachineService vendingMachineService = new VendingMachineService();
  private final OutputView outputView = new OutputView();

  // 프로그램 시작
  public void start() {
    VendingMachineCoin vendingMachineCoin = inputVendingMachineMoney();
    outputVendingMachineCoin(vendingMachineCoin);
    inputProducts();

  }

  // 자판기 보유 금액 입력
  public VendingMachineCoin inputVendingMachineMoney() {
    String input = InputView.inputVendingMachineMoney();
    return VendingMachineService.inputVendingMachineMoney(input);
  }

  // 자판기 보유 동전 출력
  public void outputVendingMachineCoin(VendingMachineCoin vendingMachineCoin) {
    Map<Coin, Integer> coins = vendingMachineService.getVendingMachineCoins(vendingMachineCoin);
    outputView.printVendingMachineCoin(coins);
  }

  // 상품 입력
  public void inputProducts() {
    String input = InputView.inputProduct();
    List<Product> products = vendingMachineService.inputProducts(input);
  }

  


}
