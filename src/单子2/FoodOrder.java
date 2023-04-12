package 单子2;

public class FoodOrder {
	private int memberID;
	private String foodOrder; // A, B, C, or D
	private int priority;

    public FoodOrder(int memberID, String foodOrder) {
		this.memberID = memberID;
		this.foodOrder = foodOrder;

		if (memberID >= 8001 && memberID <= 8199) {
			this.priority = 1;
		} else if (memberID >= 8200 && memberID <= 8999) {
			this.priority = 2;
		} else {
			this.priority = 3;
		}
    }
	public String getFoodName(String foodOrder) {
		if (foodOrder == null || foodOrder.equals("")) {
			throw new RuntimeException("foodOrder can't be null!");
		}
		String foodName = "";
		switch(foodOrder) {
			case "A":
				foodName = "Chicken Salad";
				break;
			case "B":
				foodName = "Grilled Ribeye Steak";
				break;
			case "C":
				foodName = "Angel Hair Pasta with Shrimp";
				break;
			case "D":
				foodName = "Grilled Fish and Potatoes";
				break;
		}
		return foodName;
	}
	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(String foodOrder) {
		this.foodOrder = foodOrder;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "[MemberID=" + memberID +
				" ordered Set " + foodOrder +
				" with priority " + priority + "]\n";
	}
}