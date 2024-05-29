package Topicstream_Java;
// Java code to show implementation 
// of limit() function 
import java.util.*; 

class demoLimit { 

	// Driver code 
	public static void main(String[] args) 
	{ 

		// Creating a list of integers 
		List<Integer> list = new ArrayList<Integer>(); 

		// adding elements in the list 
		list.add(-2); 
		list.add(0); 
		list.add(2); 
		list.add(4); 
		list.add(6); 
		list.add(8); 
		list.add(10); 
		list.add(12); 
		list.add(14); 
		list.add(16); 

		// setting the value of N as 4 
		int limit = 4; 
		int count = 0; 
		Iterator<Integer> it = list.iterator(); 

		// Iterating through the list of integers 
		while (it.hasNext()) { 
			it.next(); 
			count++; 

			// Check if first four i.e, (equal to N) 
			// integers are iterated. 
			if (count > limit) { 

				// If yes then remove all the remaining integers. 
				it.remove(); 
			} 
		} 

		System.out.print("New stream of length N"
						+ " after truncation is : "); 

		// Displaying new stream of length 
		// N after truncation 
		for (Integer number : list) { 
			System.out.print(number + " "); 
		} 
	} 
} 
