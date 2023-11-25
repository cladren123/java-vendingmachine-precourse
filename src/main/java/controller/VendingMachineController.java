package controller;

import model.VendingMachineCoin;
import service.VendingMachineService;
import view.InputView;

public class VendingMachineController {

  private final VendingMachineService vendingMachineService = new VendingMachineService();

  // 프로그램 시작
  public static void start() {
    VendingMachineCoin vendingMachineCoin = inputVendingMachineMoney();

  }


  // 자판기 보유 금액
  public static VendingMachineCoin inputVendingMachineMoney() {
    String input = InputView.inputVendingMachineMoney();
    return VendingMachineService.inputVendingMachineMoney(input);
  }

}
