package versuch2Queue;

public class Knoten {
	private char wert; // Das zu verwaltende Datenelement
	private Knoten next; // Referenz auf den nächsten Knoten

	public Knoten(char wert, Knoten next) {
		this.wert = wert;
		this.next = next;
	}

	/** Setzt die Referenz auf den Nachfolger-Knoten */
	public void setNext(Knoten next) {
		this.next = next;
	}

	/** Gibt das Datenelement des Knotens zurück */
	public char getElement() { // Gibt das gespeicherte Objekt aus
		return wert;
	}

	/** Gibt den Nachfolge-Knoten zurück */
	public Knoten getNext() {
		return next;
	}
}