package versuch1;

import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {

		char []array = {'h', 'e', 'l', 'p', 'o', 'q', 'u', 'i', 'c', 'k'};
		
		System.out.println("Zu sotierendes Array "+Arrays.toString(array));
		
		char[] hilfarray = new char[array.length];
		
		quickSort(array, 0, array.length -1 ,hilfarray);
		
		System.out.println("Sotiertes Array "+Arrays.toString(array));
        
    }

    public static void quickSort(char[] array, int low, int high, char[] hilfarray) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);
            System.out.println("Pivot " + array[pivotIndex] + " an Position " + pivotIndex);
            System.out.println("Array nach Partitionierung: " + Arrays.toString(array));
            
            // Recursively apply quicksort to the left and right partitions
            quickSort(array, low, pivotIndex - 1, hilfarray);
            quickSort(array, pivotIndex + 1, high, hilfarray);
        }
    }

    public static int partition(char[] array, int low, int high) {
        // Choose the pivot element (here we take the last element)
        char pivot = array[high];
        int i = low - 1;

        System.out.println("Partitionieren mit Pivot " + pivot + " zwischen Index " + low + " und " + high);

        // Move elements smaller than the pivot to the left
        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) {
                i++;
                // Swap array[i] and array[j]
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.println("Swap: " + Arrays.toString(array));
            }
        }

        // Move the pivot to the correct position
        char temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        System.out.println("Setze Pivot an Position: " + Arrays.toString(array));

        // Return the index of the pivot
        return i + 1;
    }
}
