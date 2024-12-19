package versuch2Queue;

public interface Queue {
	
	Queue enqueue(char zeichen);
	  
	Queue dequeue();
	 
	char front();

	boolean isEmpty();
}
