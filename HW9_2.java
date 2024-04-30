package HW9_2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HW9_2 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> phoneNumbers = new HashSet<>();

        System.out.println("請輸入手機號碼，輸入 0 結束:");

        while (true) {
            String phoneNumber = scanner.nextLine().trim();

            if (phoneNumber.equals("0")) {
                break;
            }

            phoneNumbers.add(phoneNumber);
        }

        System.out.println("總共輸入了 " + phoneNumbers.size() + " 個手機號碼:");

        System.out.println("所有輸入的手機號碼為:");
        for (String number : phoneNumbers) {
            System.out.println(number);
        }
    }
	

}
