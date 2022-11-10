package model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String adress;
    private double avg;

    public Student() {
    }

    public Student(int id, String name, int age, String gender, String adress, double avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.adress = adress;
        this.avg = avg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", adress='" + adress + '\'' +
                ", avg=" + avg +
                '}';
    }
}
