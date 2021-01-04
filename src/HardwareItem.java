
/*
 * HardwareItem like a Notebook, tablet or a smartphone
 * */
public class HardwareItem {
	// Specific Name of that Item
	private String name = "";
	// Weight in gramms
	private int weight;
	private double utility;
	
	public HardwareItem(String pName, int pWeight, double pUtility) 
	{
		this.name = pName;
		this.weight = pWeight;
		this.utility = pUtility;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public double getUtility() 
	{
		return this.utility;
	}
	
	public void printItem() 
	{
		System.out.println("Item: "+name+" , Weight: "+weight+", Utility: "+utility);
	}

	public String getName() {
		return this.name;
	}
}
