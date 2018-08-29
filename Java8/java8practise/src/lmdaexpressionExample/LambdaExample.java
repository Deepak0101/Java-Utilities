package lmdaexpressionExample;

import java.util.ArrayList;

/**
 * @author 310204822
 * (parameter) -> {expression body}
 * Optional type declaration
 * Optional parenthesis around parameter
 * Optional curly braces
 * Optional return keyword 
 */

interface functionalInterface{
	  void fun(int x);
	  
	  default void normalFun() {
		  System.out.println("Hello");
	  }
}

interface sumopr{
	void sum(int x, int y);
}
public class LambdaExample {
	public static void main (String args []) {
	
		 	//lambda expression to implement above
	        // functional interface. This interface
	        // by default implements abstractFun()
		functionalInterface fobj = (int x)-> System.out.println(2*x);
		fobj.fun(5);
		System.out.println("------------------------");
		sumopr summedObj = (int i, int j) -> System.out.println(i+j);
		int i = 10;
		int j = 5;
		summedObj.sum(i, j);
		System.out.println("------------------------");
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(2);
		al.add(7);
		al.add(4);
		
		// Using lambda expression to print all elements
        // of al
		
		al.forEach(n -> System.out.println(n));
		
		//lmbdas function to print even number
		
		al.forEach(n->{if(n%2==0) {System.out.println(n);}});
		
 }
	
}
