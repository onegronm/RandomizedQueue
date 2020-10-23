import java.util.Iterator;
import java.util.NoSuchElementException;

import jdk.jshell.SourceCodeAnalysis.QualifiedNames;

/**
 * @author omarn
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure. 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	Item[] q;
	private int front, rear, n;
	
	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue()
	{
		q = (Item[]) new Object[1]; // ugly cast. Generic array creation not allowed in Java
		front = rear = n = 0;
	}
	
	/**
	 * is the randomized queue empty?
	 * @return
	 */
	public boolean isEmpty() {
		return n == 0;
	}	
	
	/**
	 * @return the number of items on the randomized queue
	 */
	public int size() {
		return n;
	}
	
	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item) {
		
		if(n == q.length) {
			resize(2 * q.length);
		}
		
		if(n > 0) rear++;
		
		q[n++] = item;
	}
	
	/**
	 * Create an array of twice the size, and copy items
	 * @param length
	 */
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		
		for(int i = 0; i < n; i++) {
			copy[i] = q[front + i];
		}
		
		q = copy;
		
		// reset front and rear indexes
		front = 0;
		rear = n - 1;
	}
	
	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue() {		
		if(isEmpty())
			throw new NoSuchElementException("Queue is empty");
		
		Item item = q[front];
		q[front] = null;
		
		front++;
		n--;
		
		// halve the size of the array if one-quarter size
		if(n > 0 && n == q.length/4) {
			resize(q.length/2);
		} else if(front > rear) {
			front = 0;
		}
		
		return item;
	}
	
	/**
	 * return a random item (but do not remove it)
	 * @return
	 */
	public Item sample() {
		return null;
	}
	
	public static void main(String[] args) {
		
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		
		System.out.println("Queued: a");
		q.enqueue("a");
		System.out.println("Queued: b");
		q.enqueue("b");
		System.out.println("Queued: c");
		q.enqueue("c");
		System.out.println("Queued: d");
		q.enqueue("d");
		System.out.println("Size: " + q.size());
		System.out.println("Front: " + q.front);
		System.out.println("Rear: " + q.rear);
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println("Front: " + q.front);
		System.out.println("Rear: " + q.rear);
		System.out.println("Queued: x");
		q.enqueue("x");
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Queued: y");
		q.enqueue("y");
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Queued: z");
		q.enqueue("z");
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Queued: d, e, and f");
		q.enqueue("d");
		q.enqueue("e");
		q.enqueue("f");
		System.out.println("Size: " + q.size());
	}

	/**
	 * Each iterator must return the items in uniformly random order. 
	 * @return
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> 
	{
		private int i = n;
		private Item[] s;
		
		public ArrayIterator() {
			s = (Item[]) new Object[n];
			
			for(int i = 0; i < n; i++) {
				//int rand = StdRandom.uniform(n);
			}
		}
		
		public boolean hasNext() {
			return i > 0;
		}
		
		public Item next() {
			if(isEmpty())
				throw new NoSuchElementException("Queue is empty.");
			
			return q[--i];
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported.");
		}
		
	}
}
