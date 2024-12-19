package versuch3forChars;

class MyClosedHashtableForChars2  {
    protected int[] tagArray;
    private char[] bucketArray;
    protected int size;
    protected int capacity;
    static final int EMPTY     = 0;
    static final int OCCUPIED  = 1;
    static final int DELETED   = 2;
    public int size() { return size; }
    public int getCapacity() { return capacity; }
    public boolean isEmpty() { return size() == 0; }
    MyClosedHashtableForChars2(int aCapacity) {
        this.capacity = aCapacity;
        tagArray = new int[capacity];
        bucketArray = new char[capacity];
        for (int i = 0; i < capacity; i++) {
            tagArray[i] = EMPTY;
            bucketArray[i] = Character.MIN_VALUE;
        }
        size = 0;
    }
    /* Die Hashfunktion */
    public int getInitialHashIndex(char key) {
    	
    	// ==> Hier die Änderung ==> 
    	return Math.abs(key) % capacity;
        
    }


    /* sucht in der Hashtabelle nach Eintrag mit Schl"ussel key und liefert
        den zugeh"origen Index oder -1 zur"uck */
    public int searchForKey (char key) {
    	// ==> Hier die Änderung ==>
    	int hashIndex = getInitialHashIndex(key);
        int startIndex = hashIndex;
        while (tagArray[hashIndex] != EMPTY) {
            if (tagArray[hashIndex] == OCCUPIED && bucketArray[hashIndex] == key) {
                return hashIndex;
            }
            hashIndex = (hashIndex + 1) % capacity;
            if (hashIndex == startIndex) {
                break;
            }
        }
        return -1;
    }

    public void add(char key) {
    	// ==> Hier die Änderung ==>
    	if (size == capacity) {
            System.out.println("Hashtable is full");
            return;
        }
        int hashIndex = getInitialHashIndex(key);
        while (tagArray[hashIndex] == OCCUPIED) {
            if (bucketArray[hashIndex] == key) {
                System.out.println("Key already exists");
                return;
            }
            hashIndex = (hashIndex + 1) % capacity;
        }
        bucketArray[hashIndex] = key;
        tagArray[hashIndex] = OCCUPIED;
        size++;
    }

    public boolean remove(char key) {
    	// ==> Hier die Änderung ==>
        int hashIndex = searchForKey(key);
        if (hashIndex != -1) {
            tagArray[hashIndex] = DELETED;
            size--;
            return true;
        }
        return false; // Key not found
    }
    // ==> Hier die Änderung ==>
    public boolean find(char key) {
        return searchForKey(key) != -1; // Key not found
    }
    
//    public boolean find(int key) {
//    	if (searchForKey(key) != -1) {
//    		return true;
//    	}else {
//			return false;	// Key not found
//		}
//    }

   public void printTable () {
       for (int i = 0; i < getCapacity(); i++) {
           switch (tagArray[i]) {
               case EMPTY:
                   System.out.print("[  ]");
                   break;
               case OCCUPIED:
                   System.out.print("(");
                   System.out.print(bucketArray[i]);
                   System.out.print(")");
                   break;
               case DELETED:
                   System.out.print("{");
                   System.out.print("}");
                   break;
           }
           System.out.print(" ");
       }
       System.out.println ();
   }
   public static void testRoutines() {
           //write tests for the class here
           MyClosedHashtableForChars2 ht = new MyClosedHashtableForChars2(11);
           ht.add('1');
           ht.add('2');
           ht.add('3');
           ht.add('4');
           ht.add('5');
           ht.add('6');
           ht.add('7');
           ht.add('8');
           ht.add('a');
           ht.add('b');
           ht.printTable();
           ht.add('c');
           ht.printTable();
           System.out.println(ht.find('9'));
           System.out.println(ht.find('c'));
           ht.remove('3');
           ht.remove('6');
           ht.remove('8');
           ht.printTable();
}
    public static void main(String[] args) {
        testRoutines();
    }
}