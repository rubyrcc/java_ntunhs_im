package hw13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradeManager extends JFrame {
    private JButton addButton, findButton, deleteButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private Map<String, Student> students;

    public StudentGradeManager() {
        super("Student BMI Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        fileChooser = new JFileChooser();
        
        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Height (m):"));
        add(heightField);
        add(new JLabel("Weight (kg):"));
        add(weightField);

        addButton = new JButton("Add/Update BMI");
        addButton.addActionListener(this::addOrUpdateBMI);
        add(addButton);

        findButton = new JButton("Find BMI");
        findButton.addActionListener(this::findBMI);
        add(findButton);

        deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(this::deleteStudent);
        add(deleteButton);

        listButton = new JButton("List Students");
        listButton.addActionListener(this::listStudents);
        add(listButton);

        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        loadCSVData(); // 在程序启动时加载数据

        setVisible(true);

        // 程序退出时打开 CSV 文件
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveDataToCSV();
                Desktop.getDesktop().open(new File("data.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private void addOrUpdateBMI(ActionEvent e) {
        String name = nameField.getText();
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());
        Student student = new Student(name, height, weight);
        students.put(name, student);
        saveDataToCSV();
        textArea.setText("BMI added/updated for " + name);
    }

    private void findBMI(ActionEvent e) {
        String name = nameField.getText();
        Student student = students.get(name);
        if (student != null) {
            textArea.setText("Found: " + student.getName() + ", Height: " + student.getHeight() + "m, Weight: "
                    + student.getWeight() + "kg, BMI: " + student.getBmi());
        } else {
            textArea.setText("Student not found: " + name);
        }
    }

    private void deleteStudent(ActionEvent e) {
        String name = nameField.getText();
        if (students.remove(name) != null) {
            saveDataToCSV();
            textArea.setText("Student deleted: " + name);
        } else {
            textArea.setText("Student not found: " + name);
        }
    }

    private void listStudents(ActionEvent e) {
        StringBuilder builder = new StringBuilder("All Students:\n");
        students.values().forEach(student -> {
            builder.append("Name: ").append(student.getName()).append(", Height: ").append(student.getHeight())
                    .append("m, Weight: ").append(student.getWeight()).append("kg, BMI: ").append(student.getBmi())
                    .append("\n");
        });
        textArea.setText(builder.toString());
    }

    private void saveDataToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.csv"))) {
            writer.println("Name,Height,Weight,BMI");
            students.values().forEach(student -> writer.println(student.toString()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadCSVData() {
        File csvFile = new File("data.csv");
        if (csvFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty() || line.startsWith("Name")) continue; // 跳过标题行和空行
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0];
                        double height = Double.parseDouble(parts[1]);
                        double weight = Double.parseDouble(parts[2]);
                        Student student = new Student(name, height, weight);
                        student.calculateBMI(); // 确保BMI已计算
                        students.put(name, student);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new StudentGradeManager();
    }
}
