package Wheel_Of_Fortune;

public class Cards {
	
	private String type;
	private float value;
	
	
	public Cards(String type, float value) {
		super();
		this.type = type;
		this.value = value;
	}


	public Cards() 
	{
		super();
	}
	
	public Cards(Cards cardsCopy)
	{
		super();
		this.type = cardsCopy.type;
		this.value = cardsCopy.value;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) 
	{
		this.type = type;
	}


	public float getValue() 
	{
		return value;
	}


	public void setValue(float value) 
	{
		
		this.value = value;
	}
	

}
