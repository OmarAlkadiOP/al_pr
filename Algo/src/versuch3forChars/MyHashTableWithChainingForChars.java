package versuch3forChars;

class HashStringNode {
    public HashStringNode(char aKey) {
        key = aKey;
    }
    char key;
    HashStringNode next;
}

public class MyHashTableWithChainingForChars {
    private HashStringNode[] bucketArray;
    private int numOfBuckets = 0;
    private int size;

    public MyHashTableWithChainingForChars(int aNumOfBuckets) {
        numOfBuckets = aNumOfBuckets;
        bucketArray = new HashStringNode[numOfBuckets];
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private int getHashIndex(char key) {
    	int hashCode = Math.abs(key); //.hashCode();
        int index = hashCode % numOfBuckets;
        return index;
    }

    public boolean remove(char key) {
    	return false;
    	/*
    	int index = getHashIndex(key);
        HashCharNode head = bucketArray[index];
        HashCharNode prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    bucketArray[index] = head.next;
                }
                size--;
                return true;
            }
            prev = head;
            head = head.next;
        }
        return false;
    	 */
    }
    
    public Character get(char key) {
        int index = getHashIndex(key);
        HashStringNode head = bucketArray[index];

        while (head != null) {
            if (head.key == key) {
                return key;
            }
            head = head.next;
        }
        return null;
    }

    public void add(char key) {
        int index = getHashIndex(key);
        HashStringNode head = bucketArray[index];

        while (head != null) {
            if (head.key == key) {
                return;
            }
            head = head.next;
        }

        HashStringNode newNode = new HashStringNode(key);
        newNode.next = bucketArray[index];
        bucketArray[index] = newNode;
        size++;
    }

    public void printAllChains() {
        for (int i = 0; i < numOfBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            HashStringNode head = bucketArray[i];
            while (head != null) {
                System.out.print(head.key + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void testRoutines() {
        MyHashTableWithChainingForChars map = new MyHashTableWithChainingForChars(5);
        map.add('1');
        map.add('2');
        map.add('4');
        map.add('5');
        map.add('9');
        map.add('7');
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.printAllChains();
//        map.remove('c');
//        map.printAllChains();
//        System.out.println(map.get('d'));
//        System.out.println(map.get('z'));
    }

    public static void main(String[] args) {
        testRoutines();
    }
}