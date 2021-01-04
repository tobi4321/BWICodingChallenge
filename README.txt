
# Code Ausführen #

Das Java Projekt kann in Eclipse geöffnet werden
alternativ
können folgende Befehle in der Kommandozeile genutzt werden um die Hauptklasse und alle weiteren Klassen zu kompilieren und anschließend auszuführen.

javac.exe Main.java
java.exe Main


# Informationen über den Code #

Der Programmcode besteht aus der Hauptklasse Main.java, welche die Konsolenanwendung vollständig ausführt.
Eine Fahrer Klasse Driver.java repräsentiert einen Fahrer eines Transporters spezifiziert durch Name und Gewicht.
Das Distributionszentrum Warehouse.java speichert alle bestellten Hardwareeinheiten und wartet auf die Verteilung dieser auf die Transporter. Hier befindet sich der Verteilungsalgorithmus.
Das HardwareItem stellt eine Hardwareeinheit dar, welche einen Namen, ein Gewicht sowie einen Nutzwert besitzt. Es kann im Transporter sowie im Distributionszentrum gespeichert werden.
Der Transporter besitzt einen Fahrer sowie eine Liste der geladenen Hardwareeinheiten.

Weitere Details als Kommentare im Code


# Informationen über den gewählten Algorithmus #

Die bestmögliche Verteilung basiert auf einer sortierten Liste anhand eines Sortierungskriterium, hier Nutzwert. 
Die sortierte Liste wird anschließend gleichmäßig nach RoundRobin Verfahren auf die verfügbaren Transporter verteilt.
So bildet sich eine optimale Gleichverteilung über beliebig viele Transporter.

Hierdurch wird ein maximaler Nutzwert von 50106,0 Einheiten auf die beiden Transporter verteilt.

Der Algorithmus überspringt durch die sortierte Liste alle Elemente die bei einem Transporter die maximale Zuladung übersteigen würden und versucht diese auf die anderen Transporter zu verladen. 
Falls dies ebenfalls nicht klappt wird das Element übersprungen.



# Ausgabe des Programms #

#########################################
------- Transporter 1 ------
> Driver: Peter
> Weight: 72400g
> Utility: 0.0

------- Transporter 2 ------
> Driver: Harald
> Weight: 85700g
> Utility: 0.0

-- Warehouse Information --
> Items: 3292
> Full Weight: 6715811.0
> Full Utility: 168680.0

------- Transporter 1 ------
> Driver: Peter
> Weight: 1099885g
> Utility: 25276.0

------- Transporter 2 ------
> Driver: Harald
> Weight: 1099788g
> Utility: 24830.0

> Full Utility: 50106.0