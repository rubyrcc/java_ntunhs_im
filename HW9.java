package HW9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class HW9 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		System.out.println("叫块计块獶计挡:");
		while(scanner.hasNextInt()) {
			int num = scanner.nextInt();
			numbers.add(num);
			scanner.nextLine();
		}
		
		Collections.sort(numbers);
		
		int max = numbers.get(numbers.size() - 1);
		int min = numbers.get(0);
		double sum = 0;
		for(int num : numbers) {
			sum += num;
		}
		double average = sum / numbers.size();
		
		System.out.println("逼计:");
		for(int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println("\n程:" + max); // タ︽
		System.out.println("程:" + min);
		System.out.println("キА计:" + average);
		
	}

}
