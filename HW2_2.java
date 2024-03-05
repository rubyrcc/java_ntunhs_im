package HW2_2;

import java.util.Scanner;
import java.util.Random;

public class HW2_2 {
	public static void main(String args[]) {
		Random rand = new Random(10);
		int ans=rand.nextInt(100);
		int big = 100;
		int small = 1;
		int guess=0;
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.print("請輸入一個數字");
			guess=sc.nextInt();
			
			int validate_num=ans-guess;
			if(guess < small || guess > big) {
				System.out.println("你確定答案嗎?");
			}
			if(validate_num>0) {
				System.out.println("你猜的答案太小了");
				small=guess;
			}else if(validate_num<0) {
				System.out.println("你猜的答案太大了");
				big=guess;
			}else {
				System.out.println("你猜對答案了");
				break;
			}
		}
	}

}
