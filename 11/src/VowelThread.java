import java.util.*;
public class VowelThread extends Thread{

	String word;
	ArrayList<Character> vowels=new ArrayList<>();
	static Scanner in=new Scanner(System.in);
	
	void buildvowels()
	{
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
	}
	
	VowelThread()
	{
		buildvowels();
	}
	
	public void run()
	{
		System.out.println("\n\tENTER A WORD:\t");
		word=in.nextLine();
		System.out.println("\nVOWELS");
		for(int i=0;i<word.length();i++)
		{
			char ch=word.charAt(i);
			if(vowels.contains(ch))
			{
				System.out.println(ch+" ");
			}
		}
	}
}
