package defaultPackage;

import shirtPackage.Shirt;

final class PullOver extends Shirt
{
	boolean hashood;
	boolean hasstripes;
	
	public PullOver(int size,float price,boolean hh,boolean hs)
	{
		super(size,price);
		hashood=hh;
		hasstripes=hs;
	}
	
	public String getColor()
	{
		return super.color;
	}
	
	public void setColor(String s)
	{
		super.color=s;
	}
	
	public void getDetails()
	{
		System.out.println("\n\tSIZE:"+super.size+"\n\tPRICE:"+super.price);
		System.out.println("\n\tCOLOR"+this.getColor()+"HAS STRIPES:"+hasstripes);
		System.out.println("\n\tHAS HOOD:"+hashood);
	}
}

class FormalShirt extends Shirt
{
	boolean hasfullsleeve;
	boolean hasstripes;
	
	public FormalShirt(int size,float price,boolean hfs,boolean hs)
	{
		super(size,price);
		hasfullsleeve=hfs;
		hasstripes=hs;
	}
	
	public void setColor(String s)
	{
		super.color=s;
	}
	
	public String getColor()
	{
		return super.color;
	}
	
	public void getDetails()
	{
		System.out.println("\n\tSIZE:"+super.size+"\n\tPRICE:"+super.price);
		System.out.println("\n\tCOLOR:"+this.getColor()+"HAS STRIPES:"+hasstripes);
		System.out.println("\n\tHAS FULL SLEEVES:"+hasfullsleeve);
	}
}

class PartyWear extends FormalShirt
{
	String brand;
	
	public PartyWear(int size,float price,boolean hfs,boolean hs,String b)
	{
		super(size,price,hfs,hs);
		brand=b;
	}
	
	public String getColor()
	{
		return super.color;
	}
	
	public void setColor(String s)
	{
		super.color=s;
	}
	
	public void getDetails()
	{
		System.out.println("\n\tSIZE:"+super.size+"\n\tPRICE:"+super.price);
		System.out.println("\n\tCOLOR:"+this.getColor()+"\n\tHAS FULL SLEEVE:"+super.hasfullsleeve);
		System.out.println("\n\tBRAND:"+brand);
	}
}
public class MainShirt {
 public static void main(String [] args)
 {
	 FormalShirt fs=new FormalShirt(100,190,true,false);
	 fs.setColor("green");
	 PullOver ps=new PullOver(40,250,false,true);
	 ps.setColor("blue");
	 PartyWear pw=new PartyWear(30,500,true,true,"PUMA");
	 pw.setColor("red");
	 fs.getDetails();
	 ps.getDetails();
	 pw.getDetails();
 }
}
