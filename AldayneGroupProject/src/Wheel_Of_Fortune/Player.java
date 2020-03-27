package Wheel_Of_Fortune;

public class Player {
		private String name;
		private float grandTotal;
		private int number;
		private float round_total;
		private int numofwins;
		
		
		
		
		public Player() {
			name = "";
			grandTotal = 0;
			number = 0;
			round_total = 0;
			numofwins = 0;
		}

		public Player(String name, float grandTotal, int number, float round_total, int numofwins) {
			this.name = name;
			this.grandTotal = grandTotal;
			this.number = number;
			this.round_total = round_total;
			this.numofwins = numofwins;
		}
		
		public Player( Player playerCopy) {
			this.name = playerCopy.name;
			this.grandTotal = playerCopy.grandTotal;
			this.number = playerCopy.number;
			this.round_total = playerCopy.round_total;
			this.numofwins = playerCopy.numofwins;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getGrandTotal() {
			return grandTotal;
		}

		public void setGrandTotal(float grandTotal) {
			this.grandTotal = grandTotal;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public float getRound_total() {
			return round_total;
		}

		public void setRound_total(float round_total) {
			this.round_total = round_total;
		}

		public int getNumofwins() {
			return numofwins;
		}

		public void setNumofwins(int numofwins) {
			this.numofwins = numofwins;
		}

		@Override
		public String toString() {
			return "Player [name: " + name + ", grandTotal: " + grandTotal + ", number: " + number + ", round_total: "
					+ round_total + ", numofwins: " + numofwins + "]";
		}
		
		public void display()
		{
			System.out.println(toString());
		}
	
}
