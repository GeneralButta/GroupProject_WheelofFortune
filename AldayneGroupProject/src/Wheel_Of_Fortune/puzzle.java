package Wheel_Of_Fortune;

public class puzzle {
	private String category;
	private String puzzlephrase;
	
	
	public puzzle() {
		category = "";
		puzzlephrase = "";
	}
	
	public puzzle(String category, String puzzlephrase) {
		this.category = category;
		this.puzzlephrase = puzzlephrase;
	}

	public puzzle(puzzle puzzleCopy) {
		this.category = puzzleCopy.category;
		this.puzzlephrase = puzzleCopy.puzzlephrase;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPuzzlephrase() {
		return puzzlephrase;
	}

	public void setPuzzlephrase(String puzzlephrase) {
		this.puzzlephrase = puzzlephrase;
	}

	@Override
	public String toString() {
		return "puzzle [category=" + category + ", puzzlephrase=" + puzzlephrase + "]";
	}
	
	
	public void display()
	{
		System.out.println(toString());
		
	}
	
	

}
