package controller;

import model.VendingMachineCoin;
import service.VendingMachineMoneyService;
import service.VendingMachineService;
import view.InputView;

public class VendingMachineController {

  // 프로그램 시작
  public static void start() {
    inputVendingMachineMoney();
  }


  // 자판기 보유 금액
  public static VendingMachineCoin inputVendingMachineMoney() {
    String input = InputView.inputVendingMachineMoney();
    return VendingMachineMoneyService.inputVendingMachineMoney(input);
  }

}
