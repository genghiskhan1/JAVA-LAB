import java.util.*;
public class NumberThread extends Thread {

	HashMap<Integer,String> numbers=new HashMap<>();
	String number;
	static Scanner in=new Scanner(System.in);
	
	void loadNumbers()
	{
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
		numbers.put(7, "seven");
		numbers.put(8, "eight");
		numbers.put(9, "nine");
		numbers.put(0, "zero");
	}
	
	NumberThread()
	{
		loadNumbers();
	}
	
	public void run()
	{
		System.out.println("\n\tENTER FOUR DIGIT NUMBER:\t");
		number=in.nextLine();
		for(int i=0;i<number.length();i++)
		{
			int ch=Integer.parseInt(number.charAt(i)+"");
			System.out.println(ch+"->"+numbers.get(ch));
		}
	}
}
