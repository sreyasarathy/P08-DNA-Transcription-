//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Linked Queue 
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu
// Lecturer: Prof Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 *
 * @param <T>
 */

public class LinkedQueue<T> extends Object implements QueueADT<T> {

  private int n; // number of elements on queue
  
  private Node<T> front; // beginning of queue
  
  private Node<T> back; // end of queue

  /**
   * The following method adds the item 
   * to the end of the queue 
   *
   * @param data the item to add
   */
  
  
  @Override
  public void enqueue(T data) {

    Node<T> temp = new Node<T>(data);
    
    if (this.isEmpty()) {
    	
      this.front = temp;
      
      this.back = this.front;

    } else {
    	
      this.back.setNext(temp);
      
      this.back = this.back.getNext();
      
    }
    
    n++;
    
  }

  /**
   * The following method removes and returns 
   * the first item on the queue 
   *
   * @return the first item on the queue
   * @throws NoSuchElementException if this queue is empty
   */
  
  @Override
  public T dequeue() {
	  

    if (isEmpty()) {
    	
      throw new NoSuchElementException("Error: This queue is empty!!");
      
    }

    Node<T> newestNode = front;

    if (n == 1) {
    	
      this.front = null;
      
    } else {
    	
      this.front = front.getNext();
      
      newestNode.setNext(null);
      
      this.front.setNext(this.front.getNext());
      
    }
    
    n--;
    
    return newestNode.getData();
    
  }

  /**
   * The following method returns the item which was 
   * least recently added to the queue. 
   *
   * @return the item least recently added to this queue
   * @throws NoSuchElementException if this queue is empty
   */
  
  @Override
  public T peek() {

    if (isEmpty())
    	
      throw new NoSuchElementException("Error: This queue is empty!!");
    
    return front.getData();
    
  }

  /**
   * The following method checks whether the size 
   * is 0 or not
   * @return true if empty, false otherwise
   */
  
  @Override
  public boolean isEmpty() {

    if (size() == 0) {
    	
      return true;
      
    }
    
    return false;
    
  }

  /**
   * The following method returns 
   * the size of the queue 
   * @return size of the queue
   */
  
  @Override
  public int size() {

    return this.n;
  }

  /**
   * The toString() method creates a string representation 
   * @return string representation of the node
   */
  
  public String toString() {
	  
    String string = "";
    
    if (isEmpty()) {
    	
      return string;
      
    } else {
    	
      Node<T> node = this.front;
      
      for (int a = 0; a < size(); a++) {
    	  
        string += node.getData() + " ";
        
        node = node.getNext();
        
      }
      
      return string;
      
    }
    
  }
  
}

	