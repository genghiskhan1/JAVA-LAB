/* Write a Program that simulates a telephone that records missed incoming calls. 
   Maintain a callers list(HashMap) of 10 people . Choose or extend the most 
   appropriate collection class and provide the following features.
   Maintain an arrayList of missed calls. Numbers are recalled in the order they
   arrive. Up to 10 numbers are recorded.  When the eleventh call comes in, it 
   is stored and the oldest call is deleted so that no more than 10 numbers are 
   ever recorded.
   For each of the missed call, If the name exists in the callers list store the 
   time of the call, telephone number and the name of the caller. For unlisted 
   numbers, set the name to “private caller”.  
   After each number display, the user can select
   •	to delete the call
   •	to go on to the next missed call, or 
   •	to display the call details (number, caller name and time).
   Write a main program to create callers list, missed call list, display the missed
   call list.
 */

import java.util.*;

class MissedPhone
{
	String name,phone,time;
	MissedPhone(String n,String p,String t)
	{
		name=n;
		phone=p;
		time=t;
	}
}

class Phone
{
	String aname,pname;
	Phone(String a,String p)
	{
		aname=a;
		pname=p;
	}
}

public class PhoneClass
{
	public static void main(String [] args)
	{
	   int ch=0,count=0;
	   Calendar c=Calendar.getInstance();
	   HashMap<Integer,Phone> hm=new HashMap<>();
	   ArrayList<MissedPhone> mlist=new ArrayList<>();
	   hm.put(1,new Phone("ABC","1111"));
	   hm.put(2,new Phone("DEF","2222"));
	   hm.put(3,new Phone("GHI","3333"));
	   hm.put(4,new Phone("JKL","4444"));
	   hm.put(5,new Phone("MNO","5555"));
	   hm.put(6,new Phone("PQR","6666"));
	   hm.put(7,new Phone("STU","7777"));
	   hm.put(8,new Phone("VWX","8888"));
	   hm.put(9,new Phone("YYY","9999"));
	   hm.put(10,new Phone("ZZZ","0000"));
	   while(true)
	   {
		   System.out.println("\n\t1.ADD\n\t2.LOG\n\t3.DELETE\n\t4.EXIT");
		   System.out.println("\n\tENTER YOUR CHOICE:");
		   @SuppressWarnings("resource")
	       Scanner sc=new Scanner(System.in);
		   ch=sc.nextInt();
		   switch(ch)
		   {
		   case 1: if(count>10)
		           {
		    			mlist.remove(0);
		    			count--;
		           }
		    	   int H=c.get(Calendar.HOUR);
		    	   int M=c.get(Calendar.MINUTE);
		    	   int S=c.get(Calendar.SECOND);
		    	   String time1=H+":"+M+":"+S;
		    	   Random ran=new Random();
		    	   int num1=ran.nextInt(15)+1;
		    	   if(num1<=10)
		    	   {
		    		   Phone obj1=hm.get(num1);
		    		   mlist.add(new MissedPhone(obj1.aname,obj1.pname,time1));
		    	   }
		    	   else
		    	   {
		    		   mlist.add(new MissedPhone("PRIVATE","PRIVATE",time1));
		    	   }
		    	   count++;
		    	   break;
		    	   
		   case 2: for(int i=0;i<mlist.size();i++)
		   		   {
			    	MissedPhone obj2=mlist.get(i);
			    	System.out.println("NAME:"+obj2.name+"\nPHONE:"+obj2.phone+"\nTIME:"+obj2.time);
		            int ch1;
		            System.out.println("1.DISPLAY NEXT\n2.DISPLAY NEXT AND DELETE CURRENT");
		            System.out.println("ENTER CHOICE:");
		            ch1=sc.nextInt();
		            switch(ch1)
		            {
		               case 1: continue;
		          	      
		               case 2: mlist.remove(i);
		          	           i--;
		          	           count--;
		          	           continue;
		            }
		   		   }
		          break;
		   
		   case 3: System.out.println("\n\tENTER NUMBER TO DELETE:");
		           String num;
		           num=sc.nextLine();
		           for(int i=0;i<mlist.size();i++)
		           {
		        	   MissedPhone obj3=mlist.get(i);
		        	   if(obj3.phone==num)
		        	   {
		        		   mlist.remove(i);
		        		   count--;
		        		   i--;
		        		   System.out.println("DELETED:"+num);
		        	   }
		           }
	               break;
	               
		   case 4: System.exit(0);		     
		   }
	   }
	}
}
