//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DNA Tester 
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
 * Test methods to verify your implementation of the methods for P08.
 */

public class DNATester {


  /**
   * Tests enqueue() and dequeue() methods
   * @return if the two methods work correctly, false otherwise
   */
	
  public static boolean testEnqueueDequeue() {
	  // Checks dequeue method for exception

    try {
    	
      LinkedQueue <Character> queueTester = new LinkedQueue <Character>();
     
      try {
    	  
        queueTester.dequeue();
        
        System.out.println("Error: The dequeue() method is unable to handle " +
        
                " an empty queue!!");
        
        return false;
        
        // Checks peek method for exception
      } catch (NoSuchElementException e) {
    	  
      }

      queueTester.enqueue('N');
      
      if (!(queueTester.toString().trim().equals("N"))) {
    	  
        System.out.println("Error: The enqueue() method is unable to add a Character to" +
        
                " an empty queue!!");
        
        return false;
        
      }

    
      if (!(queueTester.dequeue().equals('N') && queueTester.toString().trim().equals(""))) {
    	  
        System.out.println("Error: The dequeue() method is unable to remove a " +
        
                "Character from a valid queue with 1 Character!!");
        
      }
      // Checks enqueue and dequeue and peek
      queueTester.enqueue('R');
      
      queueTester.enqueue('C');
      
      queueTester.enqueue('B');
      
      if (!(queueTester.toString().trim().equals("R C B"))) {
    	  
        System.out.println("Error: The enqueue() method is unable to add " +
        
                "multiple Characters to a queue!!");
            
        return false;
        
      }

    
      if (!(queueTester.dequeue().equals('R') && queueTester.toString().trim().equals("C B"))) {
    	  
        System.out.println("Error: The dequeue() method is unable to remove a " +
        
                "Character from a valid queue with 1+ Characters!!");
        
        return false;
        
      }

      return true;

    } catch (Exception e) {
    	
      System.out.println("An unknown exception developed in the testEnqueueDequeue() method.");
      
      return false;
      
    }
    
  }

  /**
   * Tests size() and isEmpty() methods
   * @return true if the methods work correctly, false otherwise
   */
  
  public static boolean testQueueSize() {

	    // Checks size method on empty queue
    try {
    	
      LinkedQueue<Character> firstTesterSize = new LinkedQueue<Character>();
      
      LinkedQueue<Character> secondTesterSize = new LinkedQueue<Character>();
      
      secondTesterSize.enqueue('S');
      
      secondTesterSize.enqueue('R');
      
      secondTesterSize.enqueue('H');

      try {
    	  
        if (firstTesterSize.size() != 0) {
        	
          return false;
          
        }
        
      } catch (Exception e) {
    	  
        System.out.println("Error: The size of sizeTester is not shown correctly for " +
        
                "an empty queue!!");
      }

      // Checks isEmpty on empty queue
      try {
    	  
        if (!firstTesterSize.isEmpty()) {
        	
          return false;
          
        }
     // Checks isEmpty and size methods after adding to queue
      } catch (Exception e) {
    	  
        System.out.println("Error: The isEmpty() method does not work correctly for an " +
        
                "empty queue!!");
      }

      try {
    	  
        if (secondTesterSize.size() != 3) {
        	
          return false;
          
        }
        
      } catch (Exception e) {
    	  
        System.out.println("Error: The size of sizeTester is not shown correctly for " +
        
                "a valid queue!!");
      }

    
      try {
    	  
        if (secondTesterSize.isEmpty()) {
        	
          return false;
          
        }
        
      } catch (Exception e) {
    	  
        System.out.println("Error: The isEmpty() method is not shown correctly for a " +
        
                "non-empty queue!!");
        
      }
      
      return true;
      
    } catch (Exception e) {
    	
      return false;
      
    }
    
  }

  /**
   * The following tester checks the transcribeDNA() method 
   * @return true if and only if the method works correctly
   */
  
  public static boolean testTranscribeDNA() {

    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    
    System.out.println(testDNA.transcribeDNA().toString());
    
    if (!(testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA))) {
    	
      return true;
      
    }

    DNA latestDNATest = new DNA("");
    
    String latestmRNA = "";
    
    System.out.println(latestDNATest.transcribeDNA().toString());
    
    if (!(latestDNATest.transcribeDNA().toString().replaceAll(" ", "").equals(latestmRNA))) {
    	
      return false;
      
    }

    return true;
    
  }


  /**
   * The following tester checks the testMRNATranslate() method
   * @return true if the method works correctly, false otherwise
   */
  
  public static boolean testMRNATranslate() {

    DNA newestDNATest = new DNA("GGAGTCAGTTAAGCG");
    
    LinkedQueue <Character> newestmRNATest = newestDNATest.transcribeDNA();
    
    if (!(newestDNATest.mRNATranslate(newestmRNATest).toString().trim().
    		
            replaceAll(" ", "").equals("PQSIR"))) {
    	
      System.out.println("Error: the testMRNATranslate() method does not work correctly or at all for a " +
      
              "valid case!!");
      
      return false;
      
    }

    DNA nextDNATest = new DNA("GGAGTCAGTTAAGCGC");
    
    LinkedQueue <Character> nextmRNATest = nextDNATest.transcribeDNA();
    
    if (!(nextDNATest.mRNATranslate(nextmRNATest).toString().trim().
    		
            replaceAll(" ", "").equals("PQSIR"))) {
    	
      System.out.println("Error: the testMRNATranslate() method does not work for a " +
      
              "case with a number of characters not a multiple of 3");
      
      return false;
      
    }

    DNA thirdDNATest = new DNA("GGAGTCAGTATCTAAGCG");
    
    LinkedQueue <Character> thirdmRNATest = thirdDNATest.transcribeDNA();
    
    if (!(thirdDNATest.mRNATranslate(thirdmRNATest).toString().trim().
    		
            replaceAll(" ", "").equals("PQS"))) {
    	
      System.out.println("Error: the testMRNATranslate() method does not work for a " +
      
              "valid case with a STOP codon");
      
      return false;
      
    }

    return true;
  }

  /**
   * This tester checks the translateDNA() method
   * @return true if and only if the method works correctly
   */
  
  public static boolean testTranslateDNA() {

    DNA testForDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    
    System.out.println(testForDNA.translateDNA().toString());
    
    if (!(testForDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD"))) {
    	
      return false;
      
    }

    DNA nextTestForDNA = new DNA("");
    
    System.out.println(nextTestForDNA.translateDNA().toString());
    
    if (!(nextTestForDNA.translateDNA().toString().replaceAll(" ", "").equals(""))) {
    	
      return false;
      
    }

 
    DNA thirdTestForDNA = new DNA("GGAGTCAGTTA");
    
    System.out.println(thirdTestForDNA.translateDNA().toString());
    
    if (!(thirdTestForDNA.translateDNA().toString().replaceAll(" ", "").equals("PQS"))) {
    	
      return false;
    }

    // tests with a STOP codon 
    DNA testWithStopCodon = new DNA("GGAGTCACTAGTTAA");
    
    System.out.println(testWithStopCodon.translateDNA().toString());
    
    if (!(testWithStopCodon.translateDNA().toString().replaceAll(" ", "").equals("PQ"))) {
    	
      return false;
      
    }

    return true;
    
  }

  /**
   * The following method runs all
   * the tester methods 
   *
   * @return true if all methods work, false otherwise
   */
  
  public static boolean All() {
	  
    return (testTranscribeDNA() && testTranslateDNA() && testEnqueueDequeue()
    		
            && testQueueSize() && testMRNATranslate());
    
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  
  public static void main(String[] args) {
	  
    System.out.println("Running all the required tests: " + All());
    
  }

}