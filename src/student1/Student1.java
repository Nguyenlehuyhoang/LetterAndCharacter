
package student1;

import java.util.Scanner;


public class Student1 {


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap ten: ");
            String name = scanner.nextLine();
            
            System.out.print("Nhap tuoi: ");
            String age = scanner.nextLine();
            
            System.out.print("Nhap gioi tinh: ");
            String gender = scanner.nextLine();
            
            System.out.print("Nhap GPA: ");
            String gpa = scanner.nextLine();
            
            System.out.print("Nhap chuyen nganh: ");
            String major = scanner.nextLine();
            
            System.out.print("Nhap que quan: ");
            String hometown = scanner.nextLine();
                    
            System.out.println("\nThong tin sinh vien: ");
            System.out.println("Nhap ten: " + name);
            System.out.println("Nhap tuoi: " + age);
            System.out.println ("Nhap gioi tinh: " + gender);  
            System.out.println("Nhag GPA: " + gpa);
            System.out.println("Nhap chuyen nganh: " + major);
            System.out.println("Nhap que quan: " + hometown);
        }
        // TODO code application logic here
    }
    
}
