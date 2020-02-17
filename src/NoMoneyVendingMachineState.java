public class NoMoneyVendingMachineState implements VendingMachineState{
	private VendingMachine vendingMachine;

	public NoMoneyVendingMachineState(VendingMachine newVendingMachine) {
		vendingMachine = newVendingMachine;
	}

	@Override
	public void insertMoney(double money) {
		System.out.println("You insert $" + money);
		vendingMachine.setInsertedMoney(money);
		vendingMachine.setState(new HasMoneyVendingMachineState(vendingMachine));
	}

	@Override
	public void typeCode(String code) {
		System.out.println("You need to insert money before typing in a code!");
	}

	@Override
	public void vendSnack(Snack snack) {
		System.out.println("You can't get a snack before inserting money!");
	}

	@Override
	public void refundMoney() {
		System.out.println("There is no money to refund!");
	}
}
