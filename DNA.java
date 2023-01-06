//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DNA 
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu 
// Lecturer: Prof Mouna Kacem
//
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

public class DNA extends Object {
	
	protected LinkedQueue <Character> DNA = new LinkedQueue<Character>();
	
	protected static String[][] mRNAtoProteinMap =
		{{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
		 {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
		 {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
		 {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
		 {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
		 {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
		 {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
		 {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
		 {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
		 {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
		 {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};
	
/**
 * The constructor for DNA that creates a queue from the given string 
 * each node has 1 character 
 *
 * @param sequence the string of DNA to be converted to a queue
 */
	  public DNA (String sequence) {
		  
	    for (int a = 0; a < sequence.length(); a++) {
	    	
	      char queueOfDNA = sequence.charAt(a);
	      
	      DNA.enqueue(queueOfDNA);
	      
	    }
	    
	  }	
	
/**
 * The following method creates and returns 
 * a new queue of mRNA characters from the stored DNA:
 * A->U, T->A, C->G, G->C
 *
 * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
 */
	  
	  public LinkedQueue <Character> transcribeDNA() {

	    LinkedQueue <Character> latestDNA = new LinkedQueue <Character> ();

	    for (int b = 0; b < DNA.size(); b++) {
	    	
	    
	    
	      char letter = this.DNA.dequeue();

	      if (letter == 'A') {
	    	  
	        latestDNA.enqueue('U');
	        
	      }
	      
	      else if (letter == 'T') {
	    	  
	        latestDNA.enqueue('A');
	        
	      }
	      
	      else if (letter == 'C') {
	    	  
	        latestDNA.enqueue('G');
	        
	      }
	      
	      else if (letter == 'G') {
	    	  
	        latestDNA.enqueue('C');
	        
	      }
	      
	      else {
	    	  
	        System.out.println(("Error: The letter is invalid!!"));
	        
	      }
	      
	      this.DNA.enqueue(letter);
	  }
	      
	      return latestDNA;
	      
	    }

	  
/**
 * The following method translates and returns 
 * a new queue of amino acids from 
 * the transcribeDNA() queue using 
 * the protein map 
 *
 * @param mRNA the mRNA queue to be translated that corresponds to the stored DNA sequence
 * @param mRNAtoProteinMap 
 * @return the queue with the amino acid sequence corresponding to the provided mRNA sequence
 */

public LinkedQueue <String> mRNATranslate(LinkedQueue <Character> mRNA) {

    LinkedQueue <String> aminoAcids = new LinkedQueue <String>();

    int loopValue = mRNA.size();
    
    for (int c = 0; c < loopValue; c++) {
 
      String stringMRNA = "";
      
     
      if (mRNA.size() >= 3) {
    	  
        for (int i = 0; i < 3; i++) {
        	
          Character letter = mRNA.dequeue();
          
          stringMRNA += letter;
          
        }

        for (int j = 0; j < (mRNAtoProteinMap.length); j++) {
        	
          if (mRNAtoProteinMap[j][0].equals(stringMRNA)) {
        	  
            if (mRNAtoProteinMap[j][1].equals("STOP")) {
            	
              return aminoAcids;
              
            } else {
            	
              aminoAcids.enqueue(mRNAtoProteinMap[j][1]);
              
            }
            
          }
          
        }
        
      }
      
    }
    
    return aminoAcids;
    
  }

/**
 * This method translates the stored DNA sequence 
 * to a queue of amino acids using the other 
 * two methods in the DNA class 
 *
 * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence
 */

public LinkedQueue <String> translateDNA() {

    LinkedQueue <Character> transcriberDNA = transcribeDNA();
    LinkedQueue <String> mRNATranslator = mRNATranslate(transcriberDNA);

    return mRNATranslator;

  }

}


    
    