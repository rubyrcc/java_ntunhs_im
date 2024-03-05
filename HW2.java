package HW2;

import java.util.Scanner;

public class HW2 {
	static String fever;
	static String cough;
	static String lazy;
	static String highbool;
	static String dry;
	static String sweats;
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner (System.in);
		System.out.println("歡迎使用醫療系統，請依序回答問題");
		System.out.println("============================");
		System.out.println("請問您最近是否發燒?:");
		fever = scanner.next();
		
		if (fever.toLowerCase().equals("y")) {
			System.out.print("請問您最近是否咳嗽?:");
			cough = scanner.next();
			
			if (cough.toLowerCase().equals("y")) {
				System.out.print("請問您最近是否疲倦?:");
				lazy = scanner.next();
					if(lazy.toLowerCase().equals("y")) {
						System.out.print("先生/小姐你有可能得感冒!!");
					}
					else {
						System.out.print("先生/小姐你有可能得其他系統!!");
					}
			}else {
				System.out.print("請問您最近是否高血壓?:");
				highbool = scanner.next();
				
				if (highbool.toLowerCase().equals("y")) {
					System.out.print("請問您最近是否口乾?:");
					dry = scanner.next();
					
					if (dry.toLowerCase().equals("y")) {
						System.out.print("先生/小姐你可能得肝病!!");
					} else {
						System.out.print("其他系統");
					}
				}else {
					System.out.print("請問您最近是否盜汗?:");
					sweats = scanner.next();
					
					if(sweats.toLowerCase().equals("y")) {
						System.out.print("先生/小姐你可能得肺病!!");
								
					}else {
						System.out.print("其他系統");
					}
				}
			}
		
		}
	}

}
