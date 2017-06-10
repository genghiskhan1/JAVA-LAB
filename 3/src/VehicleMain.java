/* Write a Java Program that does the following related to Inheritance:
a.	Create an abstract class called Vehicle which contains the ‘year_of_manufacture’ 
    data member and two abstract methods ‘getData()’ and ‘putData()’ with a constructor.
b.	Create two derived classes “TwoWheeler” and “FourWheeler” and implement the abstract
    methods. Make “FourWheeler” as final class.
c.	Create class ‘MyTwoWheeler’ which is a sub-class of “TwoWheeler” and demonstrate
     the use of super keyword to initialize data members of “MyTwoWheeler”.
*/

import java.util.*;
abstract class Vehicle
{
	int yom;
	int wheel;
	abstract void getData();
	abstract void putData();
}

final class FourWheeler extends Vehicle
{
	Scanner sc=new Scanner(System.in);
	public FourWheeler()
	{
		System.out.println("\nDETAILS OF FOUR WHEELER");
		this.wheel=4;
		
	}
	
	public void getData()
	{
		System.out.println("\n\tENTER YEAR OF MANUFACTURE:\t");
		this.yom=sc.nextInt();
	}
	
	public void putData()
	{
		System.out.println("\n\tNUMBER OF WHEELS:"+this.wheel);
		System.out.println("\n\tYEAR OF MANUFACTURE:"+this.yom);
	}
}

class TwoWheeler extends Vehicle
{
	Scanner in=new Scanner(System.in);
	TwoWheeler()
	{
		this.wheel=2;
		System.out.println("\nDETAILS OF TWO WHEELER");
	}
	
	public void getData()
	{
		System.out.println("\n\tENTER YEAR OF MANUFACTURE:\t");
		this.yom=in.nextInt();
	}
	
	public void putData()
	{
		System.out.println("\n\tNUMBER OF WHEELS:"+this.wheel);
		System.out.println("\n\tYEAR OF MANUFACTURE:\t"+this.yom);
	}
}

class MyTwoWheeler extends TwoWheeler
{
	MyTwoWheeler()
	{
		super();
		System.out.println("\nDETAILS OF MY TWO WHEELER");
	}
	
	public void getData()
	{
		super.getData();
	}
	
	public void putData()
	{
		super.putData();
	}
}
public class VehicleMain {

	public static void main(String [] args)
	{
		FourWheeler fw=new FourWheeler();
		fw.getData();
		TwoWheeler tw=new TwoWheeler();
		tw.getData();
		MyTwoWheeler mtw=new MyTwoWheeler();
		mtw.getData();
		fw.putData();
		tw.putData();
		mtw.putData();
	}
}
