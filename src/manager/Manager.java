package manager;

import model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Manager implements Serializable {
    ArrayList<Student> list;

    public Manager() {
        list = new ArrayList<>();
    }
    public final String path="src/list";
    public static void writeToFile(String path, ArrayList<Student> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list    );
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> readDataFromFile(String path){
        ArrayList<Student> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Student>)  ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void display() {
        if(list.isEmpty()){
            System.out.println("Danh sách trống");
        }else if (list.size() < 5) {
            System.out.println("Danh sach có dưới 5 sinh viên!");
            for (Student p : list) {
                System.out.println(p);
            }
        }
        if (list.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.println(list.get(i));
            }
        }
    }

    public void displayLast() {
        if (list.size() > 5) {
            for (int i = 5; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
    public void displayAll(){
        for (Student p:list){
            System.out.println(p);
        }
    }
    public void addStudent(Scanner scanner) {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập mã sinh viên:");
                String id1=scanner.nextLine();
                if (id1.isEmpty()){
                    check=false;
                    return;
                }
                int id = Integer.parseInt(id1);
                while (checkId(id)) {
                    System.out.println(" Mã sinh viên đã tồn tại! Nhập lại:");
                    id = Integer.parseInt(scanner.nextLine());
                }
                System.out.println("Nhập họ tên sinh viên:");
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi sinh của viên:");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập giới tính của sinh viên:");
                String gender = scanner.nextLine();
                System.out.println("Nhập địa chỉ của sinh viên:");
                String adress = scanner.nextLine();
                System.out.println("Nhập điểm trung bình của sinh viên:");
                double avg = Double.parseDouble(scanner.nextLine());
                Student student = new Student(id, name, age, gender, adress, avg);
                list.add(student);

                check = false;
            } catch (Exception e) {
                System.out.println("Nhập lại đúng kiểu dữ liệu và không được bỏ trống");
            }
        }
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public void updateStudent(Scanner scanner) {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập mã sinh viên :");
                String id1=scanner.nextLine();
                if (id1.isEmpty()){
                    check=false;
                    return;
                }
                int id = Integer.parseInt(id1);
                if (checkId(id) == false) {
                    System.out.println("Không tìm tấy sinh viên. Tạo mới:");
                    addStudent(scanner);
                }
                int index=findIndex(id);
                if (index!=-1){
                    System.out.println("Nhập họ tên sinh viên:");
                    String name = scanner.nextLine();
                    list.get(index).setName(name);
                    System.out.println("Nhập tuổi sinh của viên:");
                    int age = Integer.parseInt(scanner.nextLine());
                    list.get(index).setAge(age);
                    System.out.println("Nhập giới tính của sinh viên:");
                    String gender = scanner.nextLine();
                    list.get(index).setGender(gender);
                    System.out.println("Nhập địa chỉ của sinh viên:");
                    String adress = scanner.nextLine();
                    list.get(index).setAdress(adress);
                    System.out.println("Nhập điểm trung bình của sinh viên:");
                    double avg = Double.parseDouble(scanner.nextLine());
                    list.get(index).setAvg(avg);
                    check = false;
                }else {
                    System.out.println("Danh sách sinh viên trống!");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại đúng kiểu dữ liệu và không được bỏ trống");
            }
        }
    }
    public void deleteStudent(Scanner scanner){
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập mã sinh viên :");
                String id1=scanner.nextLine();
                if (id1.isEmpty()){
                    check=false;
                    return;
                }
                int id = Integer.parseInt(id1);
                while (checkId(id) == false) {
                    System.out.println("Không tìm tấy sinh viên. ");
                    id =Integer.parseInt(scanner.nextLine());
                }
                int index=findIndex(id);
                if (index!=-1){
                    System.out.println("Ấn y để xóa!");
                    System.out.println("Ấn Enter để quay về menu.");
                    String choice="N";
                    choice=scanner.nextLine();
                    switch (choice){
                        case "y":
                            list.remove(index);
                            break;
                        default:
                            break;
                    }
                    check = false;
                }else {
                    System.out.println("Danh sách sinh viên trống!");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại đúng kiểu dữ liệu và không được bỏ trống");
            }
        }
    }
    public void sapxepTangDan(){
        Collections.sort(list, Comparator.comparingDouble(Student::getAvg));
        displayAll();
    }
    public void sapxepGiamDan(){

    }
    public boolean checkId(int id) {
        boolean check = false;
        for (Student p : list) {
            if (p.getId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int findIndex(int id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }
}
