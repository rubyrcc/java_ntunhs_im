package HW5;

import java.util.Scanner;

public class HW5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isInLoop = true;
		Scanner sc = new Scanner(System.in);
		int command=0;
		
		StoreValueCard card1 = new StoreValueCard("NTUNHS001",1000,0);
		while(isInLoop) {
			int value=0;
			System.out.print("請輸入以下指令：1. 儲值 2. 扣款 3. 兌換紅利 4. 查看明細 0. 離開系統：");
			command=sc.nextInt();
			switch (command) {
				case 0:
					System.out.println("離開系統");
					isInLoop=false;
					break;
				case 1:
					System.out.print("請輸入儲值金額：");
					value=sc.nextInt();
					card1.addValue(value);
					card1.printDetails();
					break;
				case 2:
					System.out.print("請輸入扣除金額：");
					value=sc.nextInt();
					card1.charge(value);
					card1.printDetails();
					break;
				case 3:
					System.out.print("請輸入兌換紅利：");
					value=sc.nextInt();
					card1.exchangeBonus(value);
					card1.printDetails();
					break;
				case 4:
					card1.printDetails();
					break;
				default:
					System.out.println("請確認是否輸入錯誤指令：");
					break;
			}
			
		}
	}
}

class StoreValueCard {
	static int totalCardNum=0;
    String cardId;
    int balance;
    int bonus;

    
    StoreValueCard(String cardId, int balance, int bonus) {
        this.cardId = cardId;
        this.balance = balance;
        this.bonus = bonus;
        totalCardNum++;
    }
    
    void addValue(int money) {  // 儲值時呼叫的方法
        if(money > 0) {
            this.balance += money;
            if(money >= 1000) { 
                this.bonus++;
            }
        }
        else {
            System.out.println("請確認儲值金額不能為負值");
        }
    }
    
    void charge(int money) { // 扣款時呼叫的方法
        if(money > 0) {
            if(money < this.balance) {
                this.balance -= money;
            }
            else {
                System.out.println("餘額不足請儲值！");
            }
        }
        else {
            System.out.println("請確認扣款金額不能為負值");
        }
    }
    
    void exchangeBonus(int bonus) {  // 兌換紅利點數時呼叫的方法
        if(bonus > 0) {
            if(bonus  < this.bonus) {
                this.bonus -= bonus;
            }
            else {
                System.out.println("紅利不足無法兌換！");
            }
        }
        else {
        	System.out.println("請確認兌換紅利不能為負值");
        }

    }
    
    void printDetails() {
        System.out.printf("(%s, %d, %d)%n",
                this.cardId, this.balance, this.bonus);
    }
    
    int getBalance() {
        return balance;
    }

    int getBonus() {
        return bonus;
    }

    String getNumber() {
        return cardId;
    }
}



