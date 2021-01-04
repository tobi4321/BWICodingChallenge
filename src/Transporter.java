import java.util.ArrayList;
import java.util.List;

/*
 * Transporter zur Speicherung eines Fahrers und beliebig vieler Hardwareeinheiten bis zu einem zulässigen Gewicht von 1100kg.
 * */
public class Transporter {
	// Name des Transporters
	private String name;
	// Fahrer des Transporters
	private Driver driver;
	// Liste der geladenen Hardwareeinheiten
	private List<HardwareItem> loadedItems = new ArrayList<HardwareItem>();
	// maximales Zuladungsgewicht
	private final double maxWeight = 1100.0;
	// derzeitiges Gewicht
	private int currentWeight;
	
	/*
	 * Gibt Informationen über den Transporter in der Konsole aus.
	 * */
	public void printInfo(boolean fullInfo) 
	{
		System.out.println("------- "+name+" ------");
		System.out.println("> Driver: "+driver.getName());
		if(fullInfo)
		{
			for(HardwareItem i : loadedItems)
			{
				i.printItem();
			}
		}
		System.out.println("> Weight: "+currentWeight+"g");
		double usage = 0;
		for(HardwareItem i : loadedItems) 
		{
			usage = usage + i.getUtility();
		}
		System.out.println("> Utility: "+usage);
		System.out.println();
	}
	
	public Transporter(String pName, Driver pDriver) 
	{
		this.name = pName;
		this.driver = pDriver;
		this.currentWeight = this.currentWeight + pDriver.getWeight();
	}
	/*
	 * Versucht eine Hardwareeinheit zum Transporter hinzuzufügen.
	 * */
	public boolean addItem(HardwareItem item) 
	{
		if(currentWeight + item.getWeight() <= (maxWeight*1000)) 
		{
			this.loadedItems.add(item);
			currentWeight = currentWeight + item.getWeight();
			return true;
		}else 
		{
			//Item cant added, because Transporter is full
			return false;
		}
	}

	public List<HardwareItem> getLoadedItems() {
		return this.loadedItems;
	}
	
}
