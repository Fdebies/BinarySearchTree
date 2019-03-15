
import java.util.NoSuchElementException;
import java.util.LinkedList;


public class LLQueue<T> implements KQueue<T> 
{
    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
	LinkedList<T> list;
	public LLQueue()
	{
		list = new LinkedList<T>();
	}
	
	public boolean isEmpty() 
    {
		if( list.isEmpty() )
			return true;
		return false;
	}

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    public void enqueue(T item) 
    {
    	list.addFirst( item );
	}

    /** Removes the element at the "front" of this queue.
     *    @returns the removed element
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T dequeue() 
    {
		return list.removeLast();
	}

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T peekFront() 
    {
		return list.getLast();
	}
    
    public String toString() 
    {
		return list.toString();
	}
	public int size()
	{
		return list.size();
	}
 
}
