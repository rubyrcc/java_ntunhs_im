
package hw10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw10 {

    static final String FILENAME = "grades.csv"; // 指定檔案名稱

    public static void main(String[] args) {
        Map<String, Integer> grades = loadGrades(); // 讀取成績檔案中的內容

        boolean isLoop = true;
        Scanner scanner = new Scanner(System.in);

        while (isLoop) {
            String line = input("請輸入指令選擇下列功能 0.新增 1.查詢 2.修改 3.刪除 4.顯示所有 99.結束：");
            String name;
            int grade;
            switch (line) {
                case "99":
                    isLoop = false;
                    break;
                case "0":
                    name = input("請輸入學生姓名:");
                    grade = Integer.parseInt(input("請輸入學生成績:"));
                    grades.putIfAbsent(name, grade);
                    break;
                case "1":
                    name = input("請輸入學生姓名:");
                    System.out.println("學生姓名：" + name + " 成績：" + grades.get(name));
                    break;
                case "2":
                    name = input("請輸入學生姓名：");
                    if (grades.containsKey(name)) {
                        grade = Integer.parseInt(input("請輸入學生修改成績:"));
                        grades.put(name, grade);
                        System.out.println("學生姓名：" + name + " 修改後成績：" + grades.get(name));
                    } else {
                        System.out.println("學生姓名：" + name + " 不存在，請確認後再次輸入。");
                    }
                    break;
                case "3":
                    name = input("請輸入學生姓名:");
                    grades.remove(name);
                    System.out.println("學生姓名：" + name + " 已刪除");
                    break;
                case "4":
                    System.out.println("學生成績列表:");
                    for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
            }
        }

        saveGrades(grades); // 在程式結束時將哈希映射的內容寫入至檔案中
        scanner.close();
    }

    static String input(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static Map<String, Integer> loadGrades() {
        Map<String, Integer> grades = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                grades.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            // 如果檔案不存在或無法讀取，不執行任何操作，回傳空的成績列表
        }
        return grades;
    }

    static void saveGrades(Map<String, Integer> grades) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}