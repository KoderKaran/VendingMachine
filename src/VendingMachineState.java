public interface VendingMachineState {
	void insertMoney(double money);
	void typeCode(String code);
	void vendSnack(Snack snack);
	void refundMoney();
}
