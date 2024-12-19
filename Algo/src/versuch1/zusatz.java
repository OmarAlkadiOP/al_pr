package versuch1;

import javax.swing.JOptionPane;

public class zusatz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int[] array = {1, 5, 6, 8, 9, 15, 17, 23, 37, 55, 60, 70, 75, 79, 90, 95};

		 // Ausgabe des Arrays
        System.out.print("Sortiertes Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

      
        String eingabe = JOptionPane.showInputDialog("Gesuchte Zahl eingeben:");
        int zahl = Integer.parseInt(eingabe);

        // Durchführung der binären Suche
        int position = binaereSuche(array, 0, array.length - 1, zahl );

        // Ergebnisanzeige
        if (position != -1) {
            System.out.println("Gesuchtes Element gefunden an " + position + ". Stelle");
            JOptionPane.showMessageDialog(null, "Die Position der gesuchten Zahl ist " + position );
      
        } else {
            System.out.println("Gesuchtes Element nicht gefunden.");
            JOptionPane.showMessageDialog(null, "Die Zahl " + zahl + " wurde nicht im Array gefunden.");
        }
    }
	
	public static int binaereSuche(int [] array, int anfang , int ende , int zahl) {
		
		if(anfang <= ende) {
			int mitte =anfang +(ende - anfang) /2;
			
		 System.out.println("Aufruf von binaere Suche mit min=" +anfang + " und ende =" +ende);
		
		if(array[mitte] == zahl) {
			return mitte;
		
		}if(array[mitte] > zahl) {
			return binaereSuche(array, anfang, mitte -1, zahl);
		
		}else {
			return binaereSuche(array, mitte +1, ende, zahl);
		}
		
	}
		
		return -1;
	}
}