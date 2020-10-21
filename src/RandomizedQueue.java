import java.util.Iterator;

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
		return front == rear;
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

		q[n++] = item;
		rear = (rear + 1) % n;
	}
	
	/**
	 * Create an array of twice the size, and copy items
	 * @param length
	 */
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for(int i = 0; i < n; i++) {
			copy[i] = q[i];
		}
		q = copy;
	}
	
	/**
	 * remove and return a random item
	 * @return
	 */
	public Item dequeue() {
		return null;
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
		
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		System.out.println(q.size());
		System.out.println(q.front);
		System.out.println(q.rear);

	}

	/**
	 * Each iterator must return the items in uniformly random order. 
	 * @return
	 */
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
