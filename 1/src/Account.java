/*Create a class called account with the data members (Accno-integer,
  name-String,Phone_No-integer,balance_amt-float) and the following methods
  a. parameterized constructor to initialize the data members
  b.	Deposit() method which takes the amount to be deposited in to his/her
        account and do the calculation.
  c.	Withdraw() method which gets the amount to be withdrawn from his/her account.
  Print the appropriate results.
  Write a main method to read account details of  ‘n’ employees from the user. 
  If the amount in an employee account is less than 10000, display it.
*/

import java.util.*;
public class Account {
 Integer accno;
 String name;
 Integer phone;
 float balance;
 Scanner sc=new Scanner(System.in);
 
 public Account(int a,String s,int p,float b)
 {
	 accno=a;
	 name=s;
	 phone=p;
	 balance=b;
 }
 
 public Account()
 {
	 accno=0;
	 name="";
	 phone=0;
	 balance=0;
 }
 
 void getDetails()
 {
	  System.out.println("ENTER NAME:");
	  name=sc.nextLine();
	  System.out.println("ENTER ACCOUNT NUMBER:");
	  accno=sc.nextInt();
	  System.out.println("ENTER PHONE NUMBER:");
	  phone=sc.nextInt();
	  System.out.println("ENTER BALANCE:");
	  balance=sc.nextFloat();
 }
 
 void showDetails()
 {
	 System.out.println("ACCOUNT NUMBER:\t"+accno+"\nNAME:\t"+name+"\nPHONE NUMBER:\t"+phone+"\nBALANCE AMOUNT:\t"+balance);	 
 }
 
 void deposit()
 {
	 float dep;
	 System.out.println("\nENTER AMOUNT TO BE DEPOSITED:\t");
	 dep=sc.nextFloat();
	 if(dep<0)
	 {
		 System.out.println("\nINVALID DEPOSIT AMOUNT");
	 }
	 else
	 {
		 balance+=dep;
	 }
	 System.out.println("\nBALANCE:\t"+balance);
 }
 
 void withdraw()
 {
	 float with;
	 System.out.println("\nENTER AMOUNT TO BE WITHDRAWN:\t");
	 with=sc.nextFloat();
	 if(with>0&&with<=balance)
	 {
		 balance-=with;
	 }
	 else
	 {
		 System.out.println("\nINVALID WITHDRAWAL AMOUNT");
	 }
	 System.out.println("\nBALANCE:\t"+balance);
 }
 
 public static void main(String [] args)
 {
	 int n;
	 @SuppressWarnings("resource")
	 Scanner in=new Scanner(System.in);
	 System.out.println("ENTER NUMBER OF ACCOUNTS:\t");
	 n=in.nextInt();
	 Account[] A=new Account[n];
	 for(int i=0;i<n;i++)
	 {
		 A[i]=new Account();
	 }
	 System.out.println("ENTER DETAILS OF EACH ACCOUNT");
	 for(int i=0;i<n;i++)
	 {
		 A[i].getDetails();
	 }
	 int ch,num;
	 boolean flag=true;
	 while(flag)
	 {
		 System.out.println("1. DEPOSIT\n2. WITHDRAW\n3.ACCOUNTS LESS THAN 10000\n4. EXIT\nENTER CHOICE:\t");
		 ch=in.nextInt();
		 switch(ch)
		 {
		 	case 1: System.out.println("\nENTER ACCOUNT NUMBER:\t");
		 		    num=in.nextInt();
		 	        for(int i=0;i<n;i++)
		 	        {
		 	    	   if(A[i].accno==num)
		 	    	   {
		 	    		   A[i].showDetails();
		 	    		   A[i].deposit();
		 	    		   break;
		 	    	   }
		 	        }
		 	        System.out.println("\nINVALID ACCOUNT NUMBER");
		 	        break;
		 	     
		 	case 2: System.out.println("\nENTER ACCOUNT NUMBER:\t");
		 		    num=in.nextInt();
		 		    for(int i=0;i<n;i++)
		 		    {
		 		    	if(A[i].accno==num)
		 		    	{
		 		    		A[i].showDetails();
		 		    		A[i].withdraw();
		 		    		break;
		 		    	}
		 		    }
		 		    System.out.println("\nINVALID ACCOUNT NUMBER");
		 		   
		 	case 3: System.out.println("\n\tALL ACCOUNTS WITH BALANCE LESS THAN 10000");
		 	        for(int i=0;i<n;i++)
		 	        {
		 	        	if(A[i].balance<10000)
		 	        	{
		 	        		A[i].showDetails();
		 	        	}
		 	        }
		 	        break;
		 	case 4: flag=false;
		 	default:break;
		 	
		 }
	 }
  }
}
