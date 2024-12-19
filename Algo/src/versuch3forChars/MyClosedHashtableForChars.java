package versuch3forChars;

class MyClosedHashtableForChars {
	protected int[] tagArray;
	private char[] bucketArray;
	protected int size;
	protected int capacity;
	static final int EMPTY = 0;
	static final int OCCUPIED = 1;
	static final int DELETED = 2;

	public int size() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	MyClosedHashtableForChars(int aCapacity) {
		this.capacity = aCapacity;
		tagArray = new int[capacity];
		bucketArray = new char[capacity];
		for (int i = 0; i < capacity; i++) {
			tagArray[i] = EMPTY;
			bucketArray[i] = '\0';
		}
		size = 0;
	}

	/* Die Hashfunktion */
	public int getInitialHashIndex(char key) {
		return Math.abs(key) % capacity;
	}

	/*
	 * sucht in der Hashtabelle nach Eintrag mit Schlüssel key und liefert den
	 * zugehörigen Index oder -1 zurück
	 */
	public int searchForKey(char key) {
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
		int hashIndex = searchForKey(key);
		if (hashIndex != -1) {
			tagArray[hashIndex] = DELETED;
			size--;
			return true;
		}
		return false; // Key not found
	}

	public boolean find(char key) {
		return searchForKey(key) != -1; // Key not found
	}

	public void printTable() {
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
		System.out.println();
	}

	public static void testRoutines() {
		// write tests for the class here
		MyClosedHashtableForChars ht = new MyClosedHashtableForChars(11);
		ht.add('a');
		ht.add('b');
		ht.add('c');
		ht.add('d');
		ht.add('e');
		ht.add('f');
		ht.add('g');
		ht.add('h');
		ht.add('l');
		ht.add('o');
		ht.printTable();
		ht.add('p');
		ht.printTable();
		System.out.println(ht.find('z'));
		System.out.println(ht.find('c'));
		ht.remove('c');
		ht.remove('f');
		ht.remove('h');
		ht.printTable();
	}

	public static void main(String[] args) {
		testRoutines();
	}
}


//package versuch3forChars;
//
//class MyClosedHashtableForChars  {
//    protected int[] tagArray;
//    private char[] bucketArray;
//    protected int size;
//    protected int capacity;
//    static final int EMPTY     = 0;
//    static final int OCCUPIED  = 1;
//    static final int DELETED   = 2;
//    public int size() { return size; }
//    public int getCapacity() { return capacity; }
//    public boolean isEmpty() { return size() == 0; }
//    MyClosedHashtableForChars(int aCapacity) {
//        this.capacity = aCapacity;
//        tagArray = new int[capacity];
//        bucketArray = new char[capacity];
//        for (int i = 0; i < capacity; i++) {
//            tagArray[i] = EMPTY;
//            bucketArray[i] = '\0';
//        }
//        size = 0;
//    }
//    /* Die Hashfunktion */
//    public int getInitialHashIndex(char key) {
//        return Math.abs(key) % capacity;
//    }
//
//    /* sucht in der Hashtabelle nach Eintrag mit Schlüssel key und liefert
//        den zugehörigen Index oder -1 zurück */
//    public int searchForKey(char key) {
//        int hashIndex = getInitialHashIndex(key);
//        int startIndex = hashIndex;
//        while (tagArray[hashIndex] != EMPTY) {
//            if (tagArray[hashIndex] == OCCUPIED && bucketArray[hashIndex] == key) {
//                return hashIndex;
//            }
//            hashIndex = (hashIndex + 1) % capacity;
//            if (hashIndex == startIndex) {
//                break;
//            }
//        }
//        return -1;
//    }
//
//    public void add(char key) {
//        if (size == capacity) {
//            System.out.println("Hashtable is full");
//            return;
//        }
//        int hashIndex = getInitialHashIndex(key);
//        while (tagArray[hashIndex] == OCCUPIED) {
//            if (bucketArray[hashIndex] == key) {
//                System.out.println("Key already exists");
//                return;
//            }
//            hashIndex = (hashIndex + 1) % capacity;
//        }
//        bucketArray[hashIndex] = key;
//        tagArray[hashIndex] = OCCUPIED;
//        size++;
//    }
//
//    public boolean remove(char key) {
//        int hashIndex = searchForKey(key);
//        if (hashIndex != -1) {
//            tagArray[hashIndex] = DELETED;
//            size--;
//            return true;
//        }
//        return false; // Key not found
//    }
//
//    public boolean find(char key) {
//        return searchForKey(key) != -1; // Key not found
//    }
//
//    public void printTable() {
//        for (int i = 0; i < getCapacity(); i++) {
//            if (tagArray[i] == EMPTY) {
//                System.out.print("[  ] ");
//            }
//        }
//        for (int i = 0; i < getCapacity(); i++) {
//            if (tagArray[i] != EMPTY) {
//                switch (tagArray[i]) {
//                    case OCCUPIED:
//                        System.out.print("(");
//                        System.out.print(bucketArray[i]);
//                        System.out.print(")");
//                        break;
//                    case DELETED:
//                        System.out.print("{");
//                        System.out.print("}");
//                        break;
//                }
//                System.out.print(" ");
//            }
//        }
//        System.out.println();
//    }
//
//    public static void testRoutines() {
//        //write tests for the class here
//        MyClosedHashtableForChars ht = new MyClosedHashtableForChars(11);
//        ht.add('a');
//        ht.add('b');
//        ht.add('c');
//        ht.add('d');
//        ht.add('e');
//        ht.add('f');
//        ht.add('g');
//        ht.add('h');
//        ht.add('l');
//        ht.add('o');
//        ht.printTable();
//        ht.add('p');
//        ht.printTable();
//        System.out.println(ht.find('z'));
//        System.out.println(ht.find('c'));
//        ht.remove('c');
//        ht.remove('f');
//        ht.remove('h');
//        ht.printTable();
//    }
//
//    public static void main(String[] args) {
//        testRoutines();
//    }
//}
