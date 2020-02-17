import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {
	private HashMap<String, Snack> snacksInVendingMachine;
	private VendingMachineState state;
	private Scanner scn;
	private double insertedMoney;

	public VendingMachine(){
		snacksInVendingMachine = new HashMap<>();
		state = new NoMoneyVendingMachineState(this);
		insertedMoney = 0.0;
		snacksInVendingMachine.put("A1", new Snack(10, 1.25, "Donut"));
		snacksInVendingMachine.put("A2", new Snack(10, 1.00, "Cheeze Doodlez"));
		snacksInVendingMachine.put("A3", new Snack(10, 1.50, "Chips"));
		snacksInVendingMachine.put("A4", new Snack(10, 2.25, "Cinnamon Roll"));
		snacksInVendingMachine.put("A5", new Snack(10, .75, "Cup Ramen"));
		snacksInVendingMachine.put("A6", new Snack(10, 5.25, "Hot Dog"));
		scn = new Scanner(System.in);
	}

	public void printMenu(){
		System.out.println("Your current balance is: $" + insertedMoney);
		System.out.println("What would you like to do?");
		System.out.println("1-Insert money");
		System.out.println("2-Type code for snack");
		System.out.println("3-Refund money\n");
		int input = scn.nextInt();
		if(input == 1){
			insertMoney();
		}else if(input == 2){
			typeCode();
		}else if(input == 3){
			state.refundMoney();
		}else{
			System.out.println("That is not a valid option!");
		}
	}

	public void typeCode(){
		System.out.println("Which snack do you want?");
		String code = scn.next();
		if(snacksInVendingMachine.containsKey(code)){
			state.typeCode(code);
		}else{
			System.out.println("That was not a valid code!");
		}
	}

	public void insertMoney(){
		System.out.println("How much money would you like to insert?");
		double money = scn.nextDouble();
		state.insertMoney(money);
	}

	public void printOptions(){
		System.out.println("Here are the snacks and their vending codes:");
		for(Object keyName:snacksInVendingMachine.keySet()){
			Snack snack = snacksInVendingMachine.get(keyName);
			System.out.println(keyName + ":" + snack.getCount() + " " + snack.getName() + "s at $" +snack.getCost() + " each.");
		}
		System.out.println("");
	}

	public void setState(VendingMachineState newState){
		state = newState;
	}

	public VendingMachineState getState(){
		return state;
	}

	public HashMap<String, Snack> getSnacksInVendingMachine() {
		return snacksInVendingMachine;
	}

	public double getInsertedMoney() {
		return insertedMoney;
	}

	public void setInsertedMoney(double insertedMoney) {
		this.insertedMoney += insertedMoney;
	}
}
