package HW1;

import java.util.Scanner;

public class HW1 {
	static int pv;
	static int fv;
	static final double interest=0.05;
	static int interval;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pv");
		pv=sc.nextInt();
		
		System.out.println("enter interval");
		interval=sc.nextInt();
		
		fv=(int) (pv*Math.pow((1+interest), interval));
		
		System.out.println("My pv is " + pv + "and after "+ interval +"year it would be "+ fv);
	}

}
