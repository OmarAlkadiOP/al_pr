package versuch2Queue;

import java.util.NoSuchElementException;

public class DataStructureTestArray implements Queue{
	private char[] queue; // länge vom Array ist nicht bekkant
    private int index;
    private int laenge;

    public DataStructureTestArray (int laenge){
        this.laenge = laenge;
        queue = new char[laenge];
        index = -1;
    }


    @Override
    public Queue enqueue(char zeichen) {
        if(index == laenge-1){
			throw new NoSuchElementException("Array ist voll!");
        }
        index++;
        queue[index] = zeichen;
        return this;
    }

    @Override
    public Queue dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException("Array ist leer!!");
        }
    
        //shifting
        queue[0] = '\0';
        for(int i = 0; i <= index ; i++){
            queue[i] = queue[i+1];
            queue[i+1] = '\0';
        }        
        index--;

        return this;
    }

    @Override
    public char front() {
        if(isEmpty()){
            throw new NoSuchElementException("Array ist leer!!");
        }
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    public static void main(String[] args){


        // objekt vom Typ LIFO
    	DataStructureTestArray l1 = new DataStructureTestArray(8); // länge ist bekannt aber werte sind nicht bekannt

        char[] zeichen = {'1', '2', '3', '4', '5', '6', '7', '8'};
        int index = 0;
        // i < 4 (da von 0 bis 3  --> 4 durchläufe werden durchgeführt)
        char element;
        for(int i = 0; i < 4;i++){
            element = zeichen[index]; // element = zeichen[index] = zeichen[0] = '1'
            index++; // index = 1;
            System.out.println("Hinzufügtes Element = " + element);
            l1.enqueue(element);
            element = zeichen[index]; // element = zeichen[index] = zeichen[1] = '2'
            index++; // index = 2;
            System.out.println("Hinzufügtes Element = " + element);
            l1.enqueue(element);
            // l1 -> ['1', '2', , , , , , ]
            System.out.println("Entferntes Element = " + l1.front()); // gibt '2' zurück
            l1.dequeue();
            // l1 --> ['1', , , , , , , ] 
        }


        // Lösung - Variante 1
        while(!l1.isEmpty()){
            System.out.println(l1.front()); // Ausgabe letzte eingefügte Element
            l1.dequeue(); // Entfernen letzte eingefügte Element
        }

    }
}
