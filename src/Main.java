import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		printInfo();
		
		// Distributionszentrum mit zentralem Lager
		Warehouse storage = new Warehouse();
		// Spezifikationen der einzelnen Hardwareeinheiten
		HardwareItem notebook13 = new HardwareItem("Notebook Büro 13",2451,40);
		HardwareItem notebook14 = new HardwareItem("Notebook Büro 14",2978,35);
		HardwareItem notebookOutdoor = new HardwareItem("Notebook Outdoor",3625,80);
		HardwareItem mobilTelBuero = new HardwareItem("Mobiltelefon Büro",0717,30);
		HardwareItem mobilTelOutdoor = new HardwareItem("Mobiltelefon Outdoor",988,60);
		HardwareItem mobilTelHeavyDuty = new HardwareItem("Mobiltelefon Heavy Duty",1220,65);
		HardwareItem tabletBueroKlein = new HardwareItem("Tablet Büro klein",1405,40);
		HardwareItem tabletBueroGross = new HardwareItem("Tablet Büro groß",1455,40);
		HardwareItem tabletOutdoorKlein = new HardwareItem("Tablet outdoor klein",1690,45);
		HardwareItem tabletOutdoorGross = new HardwareItem("Tablet outdoor groß",1980,68);
		// hinzufügen der Hardwareeinheiten zum Distributionszentrum mit entsprechenden Häufigkeiten
		storage.addItem(notebook13, 205);
		storage.addItem(notebook14, 420);
		storage.addItem(notebookOutdoor, 450);
		storage.addItem(mobilTelBuero, 60);
		storage.addItem(mobilTelOutdoor, 157);
		storage.addItem(mobilTelHeavyDuty, 220);
		storage.addItem(tabletBueroKlein, 620);
		storage.addItem(tabletBueroGross, 250);
		storage.addItem(tabletOutdoorKlein, 540);
		storage.addItem(tabletOutdoorGross, 370);
		
		// Zwei Fahrer der Transporter mit entsprechenden Gewichten
		Driver d1 = new Driver("Peter",72.4);
		Driver d2 = new Driver("Harald",85.7);
		// Zwei Transporter mit einer maximal zulässigen Zuladung von 1100kg und fest zugewiesenen Fahrern
		Transporter t1 = new Transporter("Transporter 1",d1);
		Transporter t2 = new Transporter("Transporter 2",d2);
		
		
		// Ausgabe der Transporterinformationen vor Beladung
		t1.printInfo(false);
		t2.printInfo(false);
		// Ausgabe der Warehouse Informationen vor Beladung
		storage.printWarehouseInformations();
		
		
		// sortieren aller Hardwareeinheiten im Warehouse nach absteigendem Nutzwert 
		storage.sortItems();
		
		// Liste der verfügbaren Transporter
		List<Transporter> transportersToFill = new ArrayList<Transporter>();
		transportersToFill.add(t1);
		transportersToFill.add(t2);
		
		// Verteilung der Hardwareeinheiten 
		storage.distributeItems(transportersToFill);
		
		// Ausgabe der Transporterinformationen nach Beladung
		t1.printInfo(false);
		t2.printInfo(false);

		// Ausgabe des Gesamtnutzen 
		double fullUtility = 0.0;
		for(Transporter t : transportersToFill) 
		{
			fullUtility = fullUtility + t.getLoadedItems().stream().mapToDouble(HardwareItem::getUtility).sum();
		}
		System.out.println("> Full Utility: "+fullUtility);
	}
	
	public static void printInfo()
	{
		System.out.println("######################################");
		System.out.println("Entwickelt von Tobias Bühler");
		System.out.println("Dualer Student DHBW Karlsruhe");
		System.out.println("Studiengang Informationstechnik");
		System.out.println("######################################");
	}

}
