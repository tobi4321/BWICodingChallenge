/*
 * Fahrer eines Transporters
 * */
public class Driver {
	// Name des Fahrers
	private String name;
	// Gewicht des Fahrers in Gramm
	private int weight;
	// Erzeugt ein Fahrer Objekt
	// Angabe des Gewichts in kg
	public Driver(String pName, double pWeight) 
	{
		pWeight = pWeight * 1000;
		this.name = pName;
		this.weight = (int)pWeight;
	}

	public String getName() {
		return this.name;
	}

	public int getWeight() {
		return this.weight;
	}
}
