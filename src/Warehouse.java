import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Im Warehouse liegen die bestellten Waren und warten auf das Verladen in die Transporter.
 * 
 * Das Warehouse ist f�r die Verwaltung und die Verladung der Materialien zust�ndig.
 * 
 * */
public class Warehouse {
	// Diese Liste beinhaltet alle Elemente f�r die Auslieferung
	private List<HardwareItem> itemsToDeliver = new ArrayList<HardwareItem>();
	
	/*
	 * Hinzuf�gen von Materialien.
	 * Eine Materialie kann beliebig oft hinzugef�gt werden, zum Beispiel 420 Notebooks 14 Zoll
	 * 
	 * @param item
	 * @param amount
	 * */
	public void addItem(HardwareItem item, int amount) 
	{
		for(int i = 0; i < amount; i++ ) 
		{
			itemsToDeliver.add(new HardwareItem(item.getName()+"#"+i, item.getWeight(), item.getUtility()));
		}
	}
	
	/*
	 * Schreibt Informationen �ber die Inhalte im Warehouse in die Konsole
	 * */
	public void printWarehouseInformations() 
	{
		System.out.println("-- Warehouse Information --");
		System.out.println("> Items: "+itemsToDeliver.size());
		double weight = 0.0;
		for(HardwareItem i : itemsToDeliver) 
		{
			weight = weight + i.getWeight();
		}
		System.out.println("> Full Weight: "+weight);
		double utility = 0.0;
		for(HardwareItem i : itemsToDeliver) 
		{
			utility = utility + i.getUtility();
		}
		System.out.println("> Full Utility: "+utility);
		System.out.println();
	}
	/*
	 * sortieren der Materialien nach Nutzwert
	 * 
	 * Materialien mit hohem Nutzwert werden am Anfang der Liste einsortiert.
	 * */
	public void sortItems() 
	{
		if(itemsToDeliver.size() > 0) 
		{
			itemsToDeliver.sort(Comparator.comparingDouble(HardwareItem::getUtility).reversed());
		}
	}
	/*
	 * Verladen der vorhandenen Materialien auf eine beliebige Anzahl an Transportern.
	 * 
	 * Optimale Verteilung beruht auf der Sortierung anhand eines Kriteriums (hier Nutzwert). 
	 * Anschlie�end werden die sortierten Materialien abwechselnd auf die verf�gbaren Transporter verteilt.
	 * 
	 * So entsteht eine Gleichverteilung �ber die Transporter. 
	 * */
	public void distributeItems(List<Transporter> transporters) 
	{
		// Feststellen ob eine Materialeinheit bereits zu einem Transporter hinzugef�gt wurde.
		boolean itemAdded = false;
		// Legt fest welcher Transporter das n�chste Item erh�lt
		int transporterIterator = 0;
		// Versuche jedes Element zu einem Transporter hinzuzuf�gen
		for(int i = 0; i < itemsToDeliver.size(); i++) 
		{
			// Iteriere �ber die verf�gbaren Transporter
			for(int j = 0; j < transporters.size(); j++) 
			{
				// falls item noch nicht geladen wurde und gew�hlter Transporter �bereinstimmt belade diesen
				if(transporterIterator == j && !itemAdded) 
				{
					// versuche das entsprechende Item auf den gew�hlten Transporter zu laden.
					// erh�lt true zur�ck wenn das Item erfolgreich geladen wurde.
					// false falls transporter f�r dieses Item keinen Platz mehr hatte.
					boolean result = transporters.get(j).addItem(itemsToDeliver.get(i));
					// Pr�fe ob das Beladen erfolgreich war
					if(result)
					{
						// angeben, dass das Item nun bereits geladen wurde und nicht an die nachfolgenden Transporter beladen wird.
						itemAdded = true;
					}
					// w�hle n�chsten transporter oder beginne beim ersten
					if(transporterIterator == transporters.size() -1) 
					{
						transporterIterator = 0;
					}else { 
						transporterIterator++;
					}
				}
			}
			// falls das Item nicht hinzugef�gt werden konnte einfach weiter
			if(itemAdded) 
			{
				itemAdded = false;
			}
		}
	}
}
