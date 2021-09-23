import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextAnalyzer {
	public static void main(String[] args) throws FileNotFoundException {
		/** Reading file line by line */
		File file = new File("C:\\Users\\jenni\\OneDrive - Valencia College\\Documents\\School\\~Valencia\\Fall 2021\\CEN 3024\\TheRaven.txt");
		Scanner scan = new Scanner(file);
		/**
		 * map to store key value pair
		 * key : word
		 * value: frequency of the word
		 */
		Map<String,Integer> map = new HashMap<String, Integer>(); 
		while (scan.hasNextLine()) {
			// reading line by line
			String val = scan.nextLine(); 
			// if the string is not inserted in the map yet then insert by setting the frequency as 1
			if (map.containsKey(val) == false) 
				map.put(val,1);
			// otherwise remove the entry from map and again insert by adding 1 in the frequency
			else { 
				// finding the current frequency of the word
				int count = (int)(map.get(val)); 
				// removing the entry from the map
				map.remove(val);  
				// reinserting the word and increase frequency by 1
				map.put(val,count+1); 
			}
		}
		// retrieving the map contents
		Set<Map.Entry<String, Integer>> set = map.entrySet(); 
		// make an array list
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);  
		// sorting the array list
		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() { 
			// comparator function for sorting
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) { 
				// for descending order
				return (b.getValue()).compareTo(a.getValue());   
            }
        });
        // printing the list
		for(Map.Entry<String, Integer> i:sortedList) {
			System.out.println(i.getKey()+" -> "+i.getValue());
        }
	}
}
