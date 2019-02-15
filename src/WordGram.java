import java.util.ArrayList;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source words to be in wordgram
	 * @param start index of those words
	 * @param size size of new array
	 */ 
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = "";
		myHash = 5;
		
		// TODO: initialize myWords and others as needed
		for (int k=0; k<size; k++) {
			int j = k + start;
			myWords[k] = source[j];
		}

		}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * calculates length of myWords
	 * @return length of array
	 */
	public int length(){
		// TODO: change this
		
		return myWords.length;
	}

/**
 * checks if arrays are equal to each other
 * returns boolean
 */ 
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		
	    // TODO: complete this method
		WordGram n = (WordGram) o;
		if (Arrays.equals(n.myWords, this.myWords)) {
			return true;
		}
		
		
		return false;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 5) {
		myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return wg which is shifted wordgram without first term, last is parameter "last"
	 */
	public WordGram shiftAdd(String last) {
		ArrayList<String> x = new ArrayList<>();
		for (int k=0; k<myWords.length-1; k++) {
			x.add(myWords[k+1]);
		}
		x.add(last);
		String [] convert = new String[myWords.length];
				x.toArray(convert);
		WordGram wg = new WordGram(convert,0,myWords.length);
		// TODO: Complete this method
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method	
		if (myToString.length() == 0) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
