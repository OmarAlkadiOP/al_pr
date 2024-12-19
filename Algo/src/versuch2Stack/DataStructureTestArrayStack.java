package versuch2Stack;

public class DataStructureTestArrayStack implements Stack {
	private char[] stack; // länge vom Array ist nicht bekkant
	private int index;
	private int laenge;

	public DataStructureTestArrayStack(int laenge) {
		stack = new char[laenge];
		index = -1;
		this.laenge = laenge;
	}

	@Override
	public void push(char item) {

		if (isFull()) {
			throw new IllegalArgumentException("Array ist Voll!");
		}
		index++;
		stack[index] = item;
	}

	@Override
	public char top() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Array ist leer!");
		}
		return stack[index];
	}

	@Override
	public void pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Array ist leer!!");
		}
		stack[index] = '\0';
		index--;
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

	@Override
	public boolean isFull() {
		return index == (laenge - 1);
	}

	public static void main(String[] args) {
		// objekt vom Typ LIFO
		DataStructureTestArrayStack l1 = new DataStructureTestArrayStack(8);
		char[] zeichen = { '1', '2', '3', '4', '5', '6', '7', '8' };
		int index = 0;
		char element;
		for (int i = 0; i < 4; i++) {
			element = zeichen[index]; // element = zeichen[index] = zeichen[0] = '1'
			index++; // index = 1;
			System.out.println("Hinzufügtes Element = " + element);
			l1.push(element);
			element = zeichen[index]; // element = zeichen[index] = zeichen[1] = '2'
			index++; // index = 2;
			System.out.println("Hinzufügtes Element = " + element);
			l1.push(element);
			System.out.println("Entferntes Elementttt = " + l1.top()); // gibt '2' zurück
			l1.pop();
		}

		// Lösung - Variante 1
		while (!l1.isEmpty()) {
			System.out.println(l1.top()); // Ausgabe letzte eingefügte Element
			l1.pop(); // Entfernen letzte eingefügte Element
		}
	}
}
