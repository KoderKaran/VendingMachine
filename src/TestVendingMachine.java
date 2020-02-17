public class TestVendingMachine {
	public static void main(String[] args){
		VendingMachine vm = new VendingMachine();
		vm.printOptions();
		while(true){
			vm.printMenu();
		}
	}
}
