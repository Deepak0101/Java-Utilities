package methodreference;


import java.util.ArrayList;
import java.util.List;

public class StaticMethodReference {
	
	public static void main(String args[]) {
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		
	//with the static method reference Class::staticMethod
	al.forEach(StaticMethodReference::print);
	
	//with lambda expression   s -> String.valueOf(s)
	al.forEach(n->StaticMethodReference.print(n));
	
	}
public static void print(int i) {
	System.out.println("number   "+i);
}
}
