//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Node 
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

/**
 * Linked node class
 *
 * @param <T> data field
 */

public class Node<T> extends Object {
	
  private T data; // data field of this linked node
  
  private Node<T> next; // reference to the next linked node in a list of nodes

  /**
   * A new node is initialized with the given information
   *
   * @param data to be stored within this node
   * @throws IllegalArgumentException - with a descriptive error message if data is null
   */
  
  public Node(T data)  throws IllegalArgumentException {
	  
    this.data = data;
    
  }

  /**
   * A new node is initialized with the given information
   *
   * @param data to be stored within this node
   * @param next node, which comes after this node in a doubly linked list
   * @throws IllegalArgumentException - with a descriptive error message if data is null
   */
  
  public Node(T data, Node<T> next) throws IllegalArgumentException {

    this.data = data;
    
    this.next = next;
    
  }

  /**
   * Accessor method for this node's next node reference.
   *
   * @return the next reference to the node that comes after this one in the list, or null when this
   *         is the last node in that list
   */
  public Node<T> getNext() {
	  
    return this.next;
    
  }

  /**
   * Mutator method for this node's next node reference.
   *
   * @param next node, which comes after this node in a doubly linked list
   */
  
  public void setNext(Node<T> next) {
	  
    this.next = next;
    
  }

  /**
   * Accessor method for this node's data.
   *
   * @return the data stored within this node
   */
  
  public T getData() {
	  
    return this.data;
    
  }

}