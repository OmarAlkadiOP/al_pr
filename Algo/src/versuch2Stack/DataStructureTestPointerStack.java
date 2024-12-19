package versuch2Stack;

public class DataStructureTestPointerStack implements Stack {
	private Knoten node;

	@Override
	public void push(char item) {
		Knoten neuerNode = new Knoten(item, null);

		if (node != null) {
			neuerNode.setNext(node);
		}

		node = neuerNode;
	}

	@Override
	public char top() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stack ist leer!!");
		}
		return node.getElement();
	}

	@Override
	public void pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stqack ist leer!");
		}
		node = node.getNext();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return node == null;
	}

	public static void main(String[] args) {
		DataStructureTestPointerStack l1 = new DataStructureTestPointerStack();
		// Schreiben wir ein Array (Werte sind bekannt)
		char[] zeichen = { '1', '2', '3', '4', '5', '6', '7', '8' };
		int index = 0;
		char element;
		for (int i = 0; i < 4; i++) {
			element = zeichen[index];
			index++; // index = 1;
			System.out.println("Hinzufügtes Element = " + element);
			l1.push(element);
			element = zeichen[index];
			index++; // index = 2;
			System.out.println("Hinzufügtes Element = " + element);
			l1.push(element);
			System.out.println("Entferntes Element = " + l1.top());
			l1.pop();
		}

		// Lösung - Variante 1 -->
		while (!l1.isEmpty()) {
			System.out.println(l1.top());
			l1.pop(); // Entfernen letzte eingefügte Element
		}

	}
}
