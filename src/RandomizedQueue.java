import java.util.Iterator;

/**
 * @author omarn
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure. 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	/**
	 * construct an empty randomized queue
	 */
	public RandomizedQueue()
	{
		
	}
	
	/**
	 * is the randomized queue empty?
	 * @return
	 */
	public boolean isEmpty() {
		return false;
	}
	
	
	/**
	 * @return the number of items on the randomized queue
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * add the item
	 * @param item
	 */
	public void enqueue(Item item) {
		
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
		// TODO Auto-generated method stub

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
