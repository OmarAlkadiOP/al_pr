package versuchCountingSort;

public class CountingSortChar {

	public static void countingSort(char[] a) {
		int min = a[0];
		int max = a[0];
		// ['c', 'b', 'b', 'c', 'g', 'd'] --> a
		// range --> von 'b' bis 'g'
		// --> range = 25
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) { // if(a[1] < min) --> if('m' < 'z') --> if(Wert von m < wert von z)
				min = a[i];
			}
			if (a[i] > max) {
				max = a[i];
			}
		}
		// ['c', 'b', 'b', 'c', 'g', 'd'] --> range von 'b' --> 'g'
		// range = 103 - 98 + 1 = 6
		int range = max - min + 1;

		int[] counts = new int[range];
		// zählen
		// ['c', 'b', 'b', 'c', 'g', 'd']
		for (int i = 0; i < a.length; i++) {
			counts[a[i] - min]++;
		}

		// Aufsteigend
		int j = 0;
		for (int i = 0; i < range; i++) {
			while (counts[i] > 0) {
				a[j++] = (char) (i + min);
				counts[i]--;
			}
		}

		// Absteigend

//		int j = 0;
//		for (int i = range - 1; i >= 0; i--) {
//			while (counts[i] > 0) {
//				a[j++] = (char) (i + min);
//				counts[i]--;
//			}
//		}

		// Dann Ausgabe innerhalb der Main-Methode
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) {
				System.out.print(", ");
			}
		}

	}

	public static void main(String[] args) {
		char[] arr = { 'z', 'm', 'm', 'm', 'z', 's', 's', 's', 'b', 'c', 'f', 'd' };
		countingSort(arr);
	}
}
