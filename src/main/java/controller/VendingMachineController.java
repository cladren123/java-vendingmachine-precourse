package controller;

import constant.Coin;
import model.VendingMachineCoin;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class VendingMachineController {

  private final VendingMachineService vendingMachineService = new VendingMachineService();
  private final OutputView outputView = new OutputView();

  // 프로그램 시작
  public void start() {
    VendingMachineCoin vendingMachineCoin = inputVendingMachineMoney();
    outputVendingMachineCoin(vendingMachineCoin);

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

}
