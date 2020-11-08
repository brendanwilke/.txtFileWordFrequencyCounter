import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOrder {

	public static void main(String[] args) throws FileNotFoundException { //Driver Program
		Map<String, Integer> words1 = new HashMap<String, Integer>();
		Map<String, Integer> words2 = new HashMap<String, Integer>();
		Map<String, Integer> words3 = new HashMap<String, Integer>();
		countEachWord("dog.txt", words1); //Test Case 1
		System.out.println(sortByValue(words1));
		countEachWord("catholic.txt", words2); //Test Case 2
		System.out.println(sortByValue(words2));
		countEachWord("happy.txt", words3); //Test Case 3
		System.out.println(sortByValue(words3));
	}

	static void countEachWord(String fileName, Map<String, Integer> words) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		
		// Check to see if there are more words in the text
		while (file.hasNextLine()) {
			String word = file.next();
			
			// Set up a count variable to keep track of how many times each word appears
			Integer count = words.get(word);
			
			// If there has been an instance of the word
			if (count != null) {
				count++;
			// The word has not shown up before
			} else {
				count = 1;
			}
			// Set up the key-value pair between the word and the count in the map
			words.put(word, count);
		}
		file.close();
	}

	// Sort maps from highest value to lowest value
	public static HashMap<String, Integer> sortByValue(Map<String, Integer> words) {
		//Make a list with the elements of words
		List<Map.Entry<String, Integer>> hashElements = new LinkedList<Map.Entry<String, Integer>>(words.entrySet());
		
		//Sort the list with the highest integer values going first
		Collections.sort(hashElements, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
		
		//Put the sorted values into the newly created HashMap
        for (Map.Entry<String, Integer> aa : hashElements) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        
        return temp; 
    }

}
