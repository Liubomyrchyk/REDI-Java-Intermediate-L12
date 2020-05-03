package lesson_twelve;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Set; 

public class Main {
	public static void main(String[] args) {
		
		String newString="This string has some dublicated characters";
		//Exercise 1
		System.out.printf("Exercise 1 \n");
		Set<String> hs = new HashSet<String>();
		hs.add("banana");
		hs.add("apple");
		hs.add("orange");
		for( String element : hs) {
			System.out.println(element);
		}	
		hs.clear();
		System.out.println("All elements in Set are deleted " + hs);
		
		hs.add("grapes");
		System.out.println("Element is added "+ hs);
	
		if (hs.isEmpty()) {
			System.out.println("Our set is empty ");
		}
		else {
			System.out.println("I am not empty! ");
		}
		//Exercise 2
		System.out.printf("Exercise 2 \n");
		Set<Integer> randomSetValuesOne=randomSet(20);
		Set<Integer> randomSetValuesTwo=randomSet(20);
		System.out.println("randomSetValuesOne " + randomSetValuesOne);
		System.out.println("randomSetValuesTwo " + randomSetValuesTwo);
		//Exercise 3
		System.out.printf("Exercise 3 \n");
		System.out.println(changeToTreeSet(randomSetValuesOne));
		//Exercise 4
		System.out.printf("Exercise 4 \n");
		System.out.println(changeToTreeSet(randomSetValuesTwo));
		System.out.println(intersection(randomSetValuesOne, randomSetValuesTwo));
		//Exercise 5
		System.out.printf("Exercise 5 \n");
		System.out.println(union(randomSetValuesOne, randomSetValuesTwo));
		//Exercise 6
		System.out.printf("Exercise 6 \n");
		System.out.println(difference(randomSetValuesOne, randomSetValuesTwo));
		//Exercise 7
		System.out.printf("Exercise 7 \n");
		//Homework Exercise 1
		System.out.printf("Homework 1 \n");
		System.out.println("Difference: " + symmetricDifference(randomSetValuesOne, randomSetValuesTwo));
		
		
		
		//Homework Exercise 2
		System.out.printf("Homework 2 \n");
		System.out.println(Arrays.toString(uniqueIntegersInArray(randomSetValuesOne)));
		
		
		//Homework Exercise 3,4
		System.out.printf("Homework 3, 4 \n");
		printDuplicateOfCharacters("Java"); 
		printDuplicateOfCharacters("Intermediate Course"); 
		printDuplicateOfCharacters("REDI School");
}
	//Exercise 2
			public static Set<Integer> randomSet (int n) {
				Random rand = new Random();
				Set<Integer> ns = new HashSet<Integer>();
				while (ns.size()!=n) {
					int randomNumber = rand.nextInt(100);
					ns.add(randomNumber);
				}
				return ns;
			}
	//Exercise 3
			public static Set<Integer> changeToTreeSet (Set<Integer> ns) {
			// Convert the HashSet to TreeSet 
	        Set<Integer> hashSetToTreeSet = new TreeSet<Integer>(ns);
	        // Return the TreeSet 
	        return hashSetToTreeSet;
			}
	//Exercise 4
		 public static Set<Integer> intersection (Set<Integer> randomSet, Set<Integer> hashSetToTreeSet) {
			 Set<Integer> intersectSet = new HashSet<>(randomSet);
			 intersectSet.retainAll(hashSetToTreeSet);
			 	return intersectSet;
				}
	//Exercise 5
		 public static Set<Integer> union (Set<Integer> randomSet, Set<Integer> hashSetToTreeSet) {
			 Set<Integer> unionSet = new HashSet<>(randomSet);
			 		unionSet.addAll(hashSetToTreeSet);				 	
			 	return unionSet;	
		 }
	//Exercise 6
		 public static Set<Integer> difference (Set<Integer> randomSet, Set<Integer> hashSetToTreeSet) {
			 Set<Integer> differenceSet = new HashSet<>(randomSet);
			 		differenceSet.removeAll(hashSetToTreeSet);				 	
			 	return differenceSet;
			 	}
	//Exercise 7
			 	// not ready
		 public static TreeSet<Integer> descendingTreeSet (Set<Integer> ns) {
		
			 	Comparator<Integer> comparator = (Integer o1, Integer o2) -> (o1.compareTo(o2));
			 	TreeSet<Integer> ns1 = new TreeSet<Integer>(comparator);	
			 	
			 	return ns1;
			 	
		}	 
	//Homework Exercise 1
		 public static Set<Integer> symmetricDifference(Set<Integer> randomSetValuesOne, Set<Integer> randomSetValuesTwo) {
			    // the symmetric difference is the difference between the union
			    // of the two sets and their intersection
			    return difference(union(randomSetValuesOne, randomSetValuesTwo), intersection(randomSetValuesOne, randomSetValuesTwo));
			  }	  
	//Homework Exercise 2
		 
		 public static Integer[] uniqueIntegersInArray(Set<Integer> randomSetValuesOne) {
			   // we put all values from the input array into a set
			  Set<Integer> allValues = new HashSet<>(randomSetValuesOne);   
			  
			  Integer[] array = allValues.toArray(new Integer[0]);
			  
			  Integer[] uniqueValuesOutput = Arrays.stream(array).distinct().toArray(Integer[]::new);
	  
			    return uniqueValuesOutput;
			  }
		 

	//Homework Exercise 3, 4 
		// Find all duplicate characters in a String and print each of them. 
		public static void printDuplicateOfCharacters(String word) { 
			char[] character = word.toCharArray(); 
			
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			for (Character ch : character) { 
				if (charMap.containsKey(ch) ) { 
					charMap.put(ch, charMap.get(ch) + 1); 
				} 
					else { 
						charMap.put(ch, 1); 
				} 
			} 
		// Iterate through HashMap to print all duplicate characters of String 
				
			Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet(); 
			
			System.out.printf("List of duplicate characters in String '%s' %n \n", word); 
				
			for (Map.Entry<Character, Integer> entry : entrySet) { 
				if (entry.getValue() > 1) {
					System.out.printf("Repeated characters: \t%s : %d %n", entry.getKey(), entry.getValue());
				}
				else {System.out.printf("Unique characters: \t%s : %d %n", entry.getKey(), entry.getValue());}
			}
		} 	
		
}		 