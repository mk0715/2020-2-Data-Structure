import java.util.*;

/**
 * Generic version of the MyQueue class.
 * @param <T> the type of the value being queued
 */

class MyQueue <T> {
	private T[] queue;	// array for queue elements
	private int front, // one counterclockwise from front
	            rear, 	// array position of rear element
				capacity;	// capacity of queue array

	/**
	 * Create an empty queue whose initial capacity is cap
	 */
	@SuppressWarnings("unchecked")
	MyQueue(int cap) {
		capacity = cap;
		queue = (T []) new Object [capacity];
		front = rear = 0;
	}

	/** 
	 * If number of elements in the queue is 0, return true else return false
	 */
	boolean IsEmpty() {

		if (front != rear){
			return false;
		}

		return true;
	}
	/**
	 * Add x at rear of queue
	 */
	void Push (T x) throws Exception { 
		if((rear+1) % capacity == front){
			// if queue full, throw the following message
			throw new Exception ("Queue is Full");
		}
		rear = (rear+1) % capacity;
		queue[rear] = x;
	}

	/**
	 * Delete front element from queue
	 */
	T Pop() throws Exception {
		if (IsEmpty()) 
			// if queue is empty, throw the following message
			throw new Exception("Queue is empty. Cannot delete.");
		front = (front+1) % capacity;
		return queue[front];
	}
	
	public String toString() {
		String a = new String();
		String queueElement = new String();

		for (int i=front+1; i!=(rear+1) % capacity; i= (i+1) % capacity){
			if (i == 7){
				i = 0;
			}
			queueElement += (queue[i] + " ");
		}
		a = "MyQueue : ";
		a += queueElement;

		a += "\nrear=";
		a += Integer.toString(rear);
		a += ", front=";
		a += Integer.toString(front);
		return a;
	}
}; 


