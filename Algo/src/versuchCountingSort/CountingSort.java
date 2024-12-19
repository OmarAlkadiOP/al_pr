package versuchCountingSort;

public class CountingSort {

	public static int[] countingSort(int[] a) {
		int min = a[0];
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			if (a[i] > max) {
				max = a[i];
			}
		}
		// [2,5,3,0,-2,3,0,3
		// zwischen -2 und 5 --> 8
		int range = max - min + 1;

		// Häufigkeiten
		int[] counts = new int[range];
		// [ 0, 0, 0, 0, 0, 0] --> Array enthält intiale Werte

		// unnötig #amani
//		for (int i = 0; i < counts.length; i++) {
//			counts[i] = 0;
//		}
		// [ 0, 0, 0, 0, 0, 0, 0 , 0]

		// zählen (counting)
		for (int i = 0; i < a.length; i++) {
			counts[a[i] - min]++;
		}

		// Aufsteigend
		int j = 0;
		for (int i = 0; i < range; i++) {
			while (counts[i] > 0) {
				a[j++] = i + min;
				counts[i]--;
			}
		}

		/*
		 * Absteigend: int j = 0; for (int i = range - 1; i >= 0; i--) { while
		 * (counts[i] > 0) { a[j++] = i + min; counts[i]--; } }
		 */

		return a;
	}

	public static void main(String[] args) {
		int[] a = { 0, 3, 2, 4, 3, -1, -2, 5, -3 };
		a = countingSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) {
				System.out.print(", ");
			}
		}
	}
}