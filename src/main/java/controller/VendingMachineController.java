package controller;

import constant.Coin;
import model.VendingMachineCoin;
import service.VendingMachineService;
import view.InputView;

import java.util.Map;

public class VendingMachineController {

  private final VendingMachineService vendingMachineService = new VendingMachineService();

  // 프로그램 시작
  public void start() {
    VendingMachineCoin vendingMachineCoin = inputVendingMachineMoney();

  }

  // 자판기 보유 금액 입력
  public VendingMachineCoin inputVendingMachineMoney() {
    String input = InputView.inputVendingMachineMoney();
    return VendingMachineService.inputVendingMachineMoney(input);
  }

  // 자판기 보유 동전 출력
  public void outputVendingMachineCoin(VendingMachineCoin vendingMachineCoin) {
    Map<Coin, Integer> coins = vendingMachineService.getVendingMachineCoins(vendingMachineCoin);

  }

}
