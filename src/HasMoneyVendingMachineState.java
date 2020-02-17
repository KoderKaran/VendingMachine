public class HasMoneyVendingMachineState implements VendingMachineState {
	private VendingMachine vendingMachine;

	public HasMoneyVendingMachineState(VendingMachine newVendingMachine) {
		vendingMachine = newVendingMachine;
	}

	@Override
	public void insertMoney(double money) {
		System.out.println("You have added $" + money + " more dollars to your balance!");
		vendingMachine.setInsertedMoney(money);
	}

	@Override
	public void typeCode(String code) {
		Snack snack = vendingMachine.getSnacksInVendingMachine().get(code);
		if(snack.getCount() > 0){
			vendingMachine.setInsertedMoney(-snack.getCost());
			if(vendingMachine.getInsertedMoney() <= 0){
				vendingMachine.setState(new NoMoneyVendingMachineState(vendingMachine));
			}
			vendSnack(snack);
		}else{
			System.out.println("That snack is sold out! Please pick another snack!");
		}
	}

	@Override
	public void vendSnack(Snack snack) {
		if(vendingMachine.getInsertedMoney() <= 0){
			vendingMachine.setState(new NoMoneyVendingMachineState(vendingMachine));
		}
		System.out.println("You receive your " + snack.getName() + " and " + snack.getCost() + " has been deducted from your balance!");
		snack.setCount(-1);
	}

	@Override
	public void refundMoney() {
		vendingMachine.setInsertedMoney(-vendingMachine.getInsertedMoney());
		vendingMachine.setState(new NoMoneyVendingMachineState(vendingMachine));
		System.out.println("Your money is refunded!");
	}
}
