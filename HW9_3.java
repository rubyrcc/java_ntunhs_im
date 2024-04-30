package HW9_3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW9_3 {
	private static final Map<String, Integer> scores = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("請選擇操作：");
            System.out.println("1. 新增學生成績");
            System.out.println("2. 查詢學生成績");
            System.out.println("3. 修改學生成績");
            System.out.println("4. 刪除學生成績");
            System.out.println("5. 列出所有學生成績");
            System.out.println("0. 退出");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addScore();
                    break;
                case 2:
                    queryScore();
                    break;
                case 3:
                    modifyScore();
                    break;
                case 4:
                    deleteScore();
                    break;
                case 5:
                    listAllScores();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("無效的選擇！");
            }
        }
    }

    private static void addScore() {
        System.out.println("請輸入學生姓名：");
        String name = scanner.nextLine();
        System.out.println("請輸入學生成績：");
        int score = scanner.nextInt();
        scanner.nextLine(); // consume newline
        scores.put(name, score);
        System.out.println("學生 " + name + " 的成績已新增！");
    }

    private static void queryScore() {
        System.out.println("請輸入要查詢的學生姓名：");
        String name = scanner.nextLine();
        Integer score = scores.get(name);
        if (score != null) {
            System.out.println("學生 " + name + " 的成績為：" + score);
        } else {
            System.out.println("找不到學生 " + name + " 的成績！");
        }
    }

    private static void modifyScore() {
        System.out.println("請輸入要修改成績的學生姓名：");
        String name = scanner.nextLine();
        Integer score = scores.get(name);
        if (score != null) {
            System.out.println("請輸入新的成績：");
            int newScore = scanner.nextInt();
            scanner.nextLine(); // consume newline
            scores.put(name, newScore);
            System.out.println("學生 " + name + " 的成績已修改！");
        } else {
            System.out.println("找不到學生 " + name + " 的成績！");
        }
    }

    private static void deleteScore() {
        System.out.println("請輸入要刪除成績的學生姓名：");
        String name = scanner.nextLine();
        Integer score = scores.remove(name);
        if (score != null) {
            System.out.println("學生 " + name + " 的成績已刪除！");
        } else {
            System.out.println("找不到學生 " + name + " 的成績！");
        }
    }

    private static void listAllScores() {
        System.out.println("所有學生成績如下：");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("學生：" + entry.getKey() + "，成績：" + entry.getValue());
        }
    }

}
