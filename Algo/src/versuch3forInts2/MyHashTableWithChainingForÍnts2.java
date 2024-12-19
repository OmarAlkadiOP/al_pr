package versuch3forInts2;

//class HashIntNode {
//    public HashIntNode(int aKey) {
//        key = aKey;
//        }
//        int key;
//        HashIntNode next;
//    }
//
//    public class MyHashTableWithChainingForÍnts2 {
//        // stores array of chains
//        private HashIntNode bucketArray[];
//        private int numOfBuckets = 0;
//        private int size;
//
//        // Constructor (Initializes capacity, size and empty chains).
//
//        public MyHashTableWithChainingForÍnts2(int aNumOfBuckets) {
//            numOfBuckets = aNumOfBuckets;
//            bucketArray = new HashIntNode[numOfBuckets];
//            size = 0;
//        }
//
//        public int size() { return size; }
//        public boolean isEmpty() { return size() == 0; }
//        // This implements hash function to find index for a key
//        private int getHashIndex(int key) {
//            int hashCode = key; //.hashCode();
//            int index = hashCode % numOfBuckets;
//            return index;
//        }
//        // Method to remove a given key
//        public boolean remove(int key) {
//            // Apply hash function to find index for given key
//            return false;
//        }
//
//        // Returns value for a key
//        public int get(int key) {
//            // Find head of chain for given key
//        return -1;
//        }
//
//        // Adds a key value pair to hash
//        public void add(int key) {
//          // Find head of chain for given key
//            }
//
//    public void printAllChains() {
//        for (int i = 0; i < numOfBuckets; i++) {
//            System.out.print("Bucket " + i + ": ");
//            HashIntNode head = bucketArray[i];
//            while (head!= null) {
//                System.out.print(head.key + " -> ");
//                head = head.next;
//            }
//            System.out.println("null");
//        }
//    }
//
//    public static void testRoutines() {
//
//        MyHashTableWithChainingForÍnts2 map = new MyHashTableWithChainingForÍnts2(5);
//        map.add(1 );
//        map.add(2 );
//        map.add(4 );
//        map.add(5 );
//        map.add(14);
//        map.add(9);
//        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        map.printAllChains();
//    }
//
//    // Driver method to test Map class
//    public static void main(String[] args) {
//        testRoutines();
//    }
//}



class HashIntNode {
    public int key;
    public HashIntNode next;

    public HashIntNode(int aKey) {
        key = aKey;
        next = null;
    }
}

public class MyHashTableWithChainingForÍnts2 {
    // Speichert ein Array von Verkettungslisten (Chains)
    private HashIntNode bucketArray[];
    private int numOfBuckets = 0; // Anzahl der Buckets (Buckets = Ketten)
    private int size; // Anzahl der Elemente in der Hashtabelle

    // Konstruktor: Initialisiert die Anzahl der Buckets und leere Chains
    public MyHashTableWithChainingForÍnts2(int aNumOfBuckets) {
        numOfBuckets = aNumOfBuckets;
        bucketArray = new HashIntNode[numOfBuckets];
        size = 0;
    }

    // Gibt die Größe der Hashtabelle zurück
    public int size() {
        return size;
    }

    // Prüft, ob die Hashtabelle leer ist
    public boolean isEmpty() {
        return size() == 0;
    }

    // Implementiert die Hashfunktion zur Bestimmung des Index für einen Schlüssel
    private int getHashIndex(int key) {
        int hashCode = Math.abs(key); // Sicherstellen, dass der Hashwert positiv ist
        return hashCode % numOfBuckets;
    }

    // Fügt einen Schlüssel in die Hashtabelle ein
    public void add(int key) {
        // Berechne den Bucket-Index für den Schlüssel
        int bucketIndex = getHashIndex(key);

        // Erhalte den Anfang der Kette für diesen Index
        HashIntNode head = bucketArray[bucketIndex];

        // Überprüfen, ob der Schlüssel bereits in der Kette existiert
        while (head != null) {
            if (head.key == key) {
                // Schlüssel bereits vorhanden, keine Duplikate hinzufügen
                return;
            }
            head = head.next;
        }

        // Füge den Schlüssel am Anfang der Kette hinzu
        size++;
        head = bucketArray[bucketIndex];
        HashIntNode newNode = new HashIntNode(key);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    // Gibt den Wert für einen Schlüssel zurück (falls vorhanden)
    public int get(int key) {
        int bucketIndex = getHashIndex(key);
        HashIntNode head = bucketArray[bucketIndex];

        // Suche den Schlüssel in der Kette
        while (head != null) {
            if (head.key == key) {
                return key; // Schlüssel gefunden
            }
            head = head.next;
        }
        return -1; // Schlüssel nicht gefunden
    }

    // Gibt alle Ketten der Hashtabelle aus
    public void printAllChains() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            HashIntNode head = bucketArray[i];
            while (head != null) {
                System.out.print(head.key + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    // Testmethoden zur Überprüfung der Implementierung
    public static void testRoutines() {
        MyHashTableWithChainingForÍnts2 map = new MyHashTableWithChainingForÍnts2(5);
        map.add(1);
        map.add(2);
        map.add(4);
        map.add(5);
        map.add(14);
        map.add(9);
        System.out.println(map.size()); // Erwartete Ausgabe: 6
        System.out.println(map.isEmpty()); // Erwartete Ausgabe: false
        map.printAllChains();
    }

    // Hauptmethode zur Ausführung der Tests
    public static void main(String[] args) {
        testRoutines();
    }
}