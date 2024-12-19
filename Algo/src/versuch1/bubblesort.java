package versuch1;

import java.util.Arrays;

public class bubblesort {

    public static void main(String[] args) {
        int[] array = {87, 80, 65, 77, 39, 88, 22, 11};

        System.out.println("Zu sortierendes Array: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Sortiertes Array: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        // Outer loop to go over each element
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop to compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.println("Vergleiche " + array[j] + " und " + array[j + 1]);

                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    System.out.println("Array nach Swap: " + Arrays.toString(array));
                }
            }

            // If no two elements were swapped, the array is sorted
            if (!swapped) break;
        }
    }
}
