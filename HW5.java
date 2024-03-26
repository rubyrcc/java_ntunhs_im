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
			System.out.print("�п�J�H�U���O�G1. �x�� 2. ���� 3. �I�����Q 4. �d�ݩ��� 0. ���}�t�ΡG");
			command=sc.nextInt();
			switch (command) {
				case 0:
					System.out.println("���}�t��");
					isInLoop=false;
					break;
				case 1:
					System.out.print("�п�J�x�Ȫ��B�G");
					value=sc.nextInt();
					card1.addValue(value);
					card1.printDetails();
					break;
				case 2:
					System.out.print("�п�J�������B�G");
					value=sc.nextInt();
					card1.charge(value);
					card1.printDetails();
					break;
				case 3:
					System.out.print("�п�J�I�����Q�G");
					value=sc.nextInt();
					card1.exchangeBonus(value);
					card1.printDetails();
					break;
				case 4:
					card1.printDetails();
					break;
				default:
					System.out.println("�нT�{�O�_��J���~���O�G");
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
    
    void addValue(int money) {  // �x�ȮɩI�s����k
        if(money > 0) {
            this.balance += money;
            if(money >= 1000) { 
                this.bonus++;
            }
        }
        else {
            System.out.println("�нT�{�x�Ȫ��B���ର�t��");
        }
    }
    
    void charge(int money) { // ���ڮɩI�s����k
        if(money > 0) {
            if(money < this.balance) {
                this.balance -= money;
            }
            else {
                System.out.println("�l�B�������x�ȡI");
            }
        }
        else {
            System.out.println("�нT�{���ڪ��B���ର�t��");
        }
    }
    
    void exchangeBonus(int bonus) {  // �I�����Q�I�ƮɩI�s����k
        if(bonus > 0) {
            if(bonus  < this.bonus) {
                this.bonus -= bonus;
            }
            else {
                System.out.println("���Q�����L�k�I���I");
            }
        }
        else {
        	System.out.println("�нT�{�I�����Q���ର�t��");
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



