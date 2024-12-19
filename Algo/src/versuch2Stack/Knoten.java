package versuch2Stack;

public class Knoten {
	private char wert;
	private Knoten next;

	public Knoten(char wert, Knoten next) {
		     this.wert = wert;
		     this.next = next;
		 }

	public void setNext(Knoten next) {
		this.next = next;
	}

	public char getElement() {
		return wert;
	}

	public Knoten getNext() {
		return next;
	}

}
