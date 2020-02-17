public class Snack {
	private int count;
	private double cost;
	private String name;

	public Snack(int newCount, double newCost, String newName){
		count = newCount;
		cost = newCost;
		name = newName;

	}

	public double getCost() {
		return cost;
	}

	public void setCount(int newCount){
		count += newCount;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}
}
