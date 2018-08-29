package streams.api.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamApiExample {
	public static void main (String args[]) {
		
		
		List<String> al = new ArrayList<>();
		al.add("Deepak");
		al.add("");
		al.add("arpan");
		al.add("Umang");
		//print list by iterating
		System.out.println("List : "+al);
		
		// Count empty strings
		long count = al.stream().filter(alist->alist.isEmpty()).count();
		  System.out.println("Empty Strings: " + count);
		  
		//string of leghth 5
		long leghth5 = al.stream().filter(len5->(len5.length()==5)).count();
		System.out.println("Strings of len 5 : " + leghth5);
		
		//Eliminate empty string
		//colectors returns list or string and used to combine the result
		al = al.stream().filter(blankvalue ->!blankvalue.isEmpty()).collect(Collectors.toList());
		System.out.println("new List : "+al);
		
		//merge  string
		String merged = al.stream().filter(blankvalue->!blankvalue.isEmpty()).collect(Collectors.joining(", "));
		System.out.println(merged);
		
		// square of the list
		//The ‘map’ method is used to map each element to its corresponding resu
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		numbers = numbers.stream().map(i->i*i).collect(Collectors.toList());
		System.out.println(numbers);
		
		//stats collection
		
		IntSummaryStatistics stats = numbers.stream().mapToInt(i->i).summaryStatistics();
		 System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      
	      //print ten random numbers
	      Random random = new Random();
	      random.ints().limit(10).sorted().forEach(System.out::println);
	}

}
