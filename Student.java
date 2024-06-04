package hw13;

public class Student {
    private String name;
    private double height;
    private double weight;
    private double bmi;

    public Student(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.calculateBMI(); // 在构造函数中计算BMI
    }

    public void calculateBMI() {
        this.bmi = Math.round((weight / (height * height)) * 100.0) / 100.0; // 计算BMI值，保留两位小数
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }

    @Override
    public String toString() {
        return name + "," + height + "," + weight + "," + bmi;
    }
}