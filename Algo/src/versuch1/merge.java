package versuch1;

import java.util.Arrays;

public class merge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char []array = {'c', 'j', 'l', 't', 'k', 's', 'k', 'i'};
		
		System.out.println("Zu sotierendes Array "+Arrays.toString(array));
		
		char[] hilfarray = new char[array.length];
		
		sortiere(array, 0, array.length -1 ,hilfarray);
		
		System.out.println("Sotiertes Array "+Arrays.toString(array));
		
	}
	public static void sortiere(char[] array, int anfang, int ende, char[] hilfarray) {
		if(anfang < ende) {
			int mitte = (anfang + ende) / 2;
			
			sortiere(array, anfang, mitte, hilfarray);
			sortiere(array, mitte+1, ende, hilfarray);
			mergeSort(array, anfang, mitte, ende, hilfarray);
			System.out.println("Gemergter teil ist nun: "+ Arrays.toString(Arrays.copyOfRange(array, anfang, ende +1)));
			
		}
	}
	public static void mergeSort(char[] array, int anfang, int mitte, int ende, char[] hilfarray) {
		hilfarray = Arrays.copyOfRange(array, anfang, ende +1);
		
		int a = anfang;
		int m = mitte +1;
		int aa = anfang;
		
		System.out.println("Aufruf von sortiere mit anfang: "+ anfang +" und ende: "+ende);
		System.out.println("zu mergender Array: "+Arrays.toString(array));
		
		while(a <= mitte && m <= ende) {
			if(hilfarray[a-anfang] <= hilfarray[m-anfang]) {
				array[aa] = hilfarray[a-anfang];
				a++;
			}
			else {
				array[aa] = hilfarray[m-anfang];
				m++;
			}
			aa++;
		}
		while(a <= mitte) {
			array[aa]= hilfarray[a-anfang];
			a++;
			aa++;
		}
	}
}
