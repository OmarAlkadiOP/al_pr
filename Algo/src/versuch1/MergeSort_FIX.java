package versuch1;

public class MergeSort_FIX {

	public static void main(String[] args) {
		int[] a = { 40, 20, 7, 80, 60, 50, 10, 30, 17, 42 };

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		mergeSort(a);

		for (int j : a) {
			System.out.print(j + " ");
		}
	}

	public static void mergeSort(int[] a) {
		int[] helpa = new int[a.length];
		doMergeSort(a, 0, a.length - 1, helpa);
	}

	private static void doMergeSort(int[] a, int left, int right, int[] helpa) {
		if (right - left > 0) {
			int middle = (left + right) / 2;
			doMergeSort(a, left, middle, helpa); // Sortiere a[left,…,middle]
			doMergeSort(a, middle + 1, right, helpa); // Sortiere a[middle+1,…,right]
			mergeParts(a, helpa, left, middle, right); // Füge die 2 Teile zusammen
		}

	}

	public static void mergeParts(int[] a, int[] helpA, int leftEnd, int middle, int rightEnd) {
		for (int i = leftEnd; i <= rightEnd; i++) {
			helpA[i] = a[i];
		}
		int leftIndex = leftEnd;
		int rightIndex = middle + 1;
		int outIndex = leftEnd;
		while (leftIndex <= middle && rightIndex <= rightEnd) { // alternative: use for-

			if (helpA[leftIndex] < helpA[rightIndex]) {
				a[outIndex] = helpA[leftIndex];
				leftIndex++;
			} else {
				a[outIndex] = helpA[rightIndex];
				rightIndex++;
			}
			outIndex++;
		}
		while (leftIndex <= middle) { // Copy rest of first half, if needed
			a[outIndex] = helpA[leftIndex];
			outIndex++;
			leftIndex++;
		}
		while (rightIndex <= rightEnd) { // Copy rest of second half, if needed
			a[outIndex] = helpA[outIndex];
			outIndex++;
			rightIndex++;
		}
	}

}
