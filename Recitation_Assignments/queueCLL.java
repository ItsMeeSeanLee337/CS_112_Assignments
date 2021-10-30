import java.util.Iterator;
import java.util.StringJoiner;

//Note, to test, must have StdOut.java
/**
 * Created by Rene Argento
 */
public class queueCLL<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}
	
	Node last;
	int size;
	
	public boolean isEmpty() {
		return //YOUR CODE HERE
	}
	
	public int size() {
		return //YOUR CODE HERE
	}
	
	public void enqueue(Item item) {
		if (isEmpty()) {
			//YOUR CODE HERE
		} else {
			Node node = new Node();
			node.item = item;
			
			if (size == 1) {
				//YOUR CODE HERE
			} else {
				//YOUR CODE HERE
			}
			//reset the "last" pointer
		}
		size++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			//YOUR CODE HERE
		}
		
		Item item;
		
		if (size == 1) {
			//YOUR CODE HERE
			
		} else {
			//YOUR CODE HERE
		}
		size--;
		
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		
		private Node current;
		int count = 0;
		
		public QueueIterator() {
			if (last != null && size > 1) {
				current = last.next;
			} else {
				current = last;
			}
		}
		
		public Item next() {
			count++;
			
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public boolean hasNext() {
			return count < size;
		}
	}
	
	public static void main (String[] args) {
		queueCLL<Integer> queue = new queueCLL<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);

        StringJoiner queueItems = new StringJoiner(" ");
        for (int item : queue) {
            queueItems.add(String.valueOf(item));
        }

        StdOut.println("Queue items: " + queueItems.toString());
        StdOut.println("Expected: 1 2 3 4");
	}
	
}
