package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2; key="be", value=2; key="or", value=1; key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {

		Map<String, Integer> wordcount = new HashMap<String, Integer>();

		for (int i = 0; i < words.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(j).equals(words.get(i))) {
					count++;
				}
			}
			int test = 0;
			for (int k = 0; k < i; k++) {
				if (words.get(k).equals(words.get(i))) {
					test++;
				}
			}
			if (test == 0) {
				wordcount.put(words.get(i), count);
			}
		}

		return wordcount;
	}
}
