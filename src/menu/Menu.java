package menu;

import manager.Manager;

import java.io.FileWriter;
import java.lang.reflect.GenericDeclaration;
import java.util.Scanner;

public class Menu {
public void menu(Scanner scanner){
        Manager manager=new Manager();
    manager.setList(Manager.readDataFromFile(manager.path));
    System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
    int choice1=-1;
        do{
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1.Xem danh sách sinh viên");
            System.out.println("2.Thêm mới");
            System.out.println("3.Xóa");
            System.out.println("4. Cập nhật");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng:");
            choice1=Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    manager.display();
                    String enter=scanner.nextLine();
                    if (enter.isEmpty()){
                        manager.displayLast();
                        break;
                    }
                    break;
                case 2:
                    manager.addStudent(scanner);
                    break;
                case 3:
                    manager.deleteStudent(scanner);
                    break;
                case 4:
                    manager.updateStudent(scanner);
                    break;
                case 5:
                    manager.sapxepTangDan();
                case 6:
                    manager.setList(Manager.readDataFromFile(manager.path));
                    break;
                case 7:
                    Manager.writeToFile(manager.path, manager.getList());
                case 8:
            }
        }while (choice1!=8);
    }
}
