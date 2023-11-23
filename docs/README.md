# 미션 - 자판기


## 핵심 기능
반환되는 동전이 최소한이 되도록 구현한다. 


## 기능 요구사항
* 자판기가 보유한 금액으로 동전 무작위 생성
* 잔돈을 돌려줄 땐 현재 보유한 최소 개수의 동전으로 돌려줌
* 상품명, 가격, 수량을 입력하여 상품 추가 
  * 상품 가격은 100원부터 시작, 10원으로 나눠떨어져야 한다.
* 사용자가 투입한 금액으로 상품을 구매할 수 있다.
* 남은 그맥이 상품의 최저 가격보다 적가나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
* 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환
  * 반환되지 않은 금액은 자판기에 남는다. 
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고 [Error]로 시작하는 메세지를 출력 후 해당 부분부터 다시 입력


## 세부 기능 

### VendingMachineController
자판기의 흐름을 설정하는 컨트롤러 

- [ ] inputVendingMachineMoney() : 자판기가 보유한 금액 입력
- [ ] inputProduct() : 상품명과 가격, 수량 입력
- [ ] inputCustomerMoney() : 투입 금액 입력 
- [ ] inputBuyProduct() : 구매할 상품명 입력 

### InputView
입력 화면 출력

- [X] inputVendingMachineMoney() : 자판기가 보유한 금액 입력
- [X] inputProduct() : 상품명, 가격, 수량 입력
- [X] inputCustomerMoney() : 투입 금액 입력 
- [X] inputBuyProduct() : 구매할 상품명 입력 


### OutputView
결과 화면 출력

- [ ] outputVendingMachineMoney() : 자판기가 보유한 동전 출력 
- [ ] outputChange() : 잔돈 출력


### VendingMachineService
자판기에 관한 비즈니스 로직 처리 

- [ ] inputBuyProduct() : 구매할 상품명 입력


### VendingMachine
자판기 정보 저장 및 도메인 로직 처리
* 상품 리스트

- [ ] buyProduct() : 상품 수량만큼 금액을 뺀다.
- [ ] checkCustomerMoney() : 투입 금액이 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.



### VendingMachineCoinService 
자판기가 보유한 금액에 관한 비즈니스 로직 처리

- [X] inputVendingMachineMoney() : 자판기가 보유한 금액 입력

### VendingMachineCoin
자판기가 보유한 금액(동전) 

- [X] changeCoin() : 잔돈의 코인을 계산한다. 


### Product 
상품 정보 관리 

- [ ] buyProduct() : 상품을 사고 남은 돈을 반환 


### CustomerMoney 
사용자가 투입한 금액 


### Validate
검증 작업 

- [X] validateNumber() : 숫자인지 검증
- [ ] validateProduct() : 상품명 형식 검증


### Converter
변환 작업 

- [X] StringToNumber() : 문자열을 숫자로 변환
- [ ] inputToProduct() : 상품 입력을 상품 형식으로 변환


### Enum 
enum 클래스 모음

- [ ] Coin : 동전 상수 관리
- [X] InputMessage : 입력 메세지 관리
- [ ] OutputMessage : 출력 메세지 관리
- [X] ErrorMessage : 에러 메시지 관리 

