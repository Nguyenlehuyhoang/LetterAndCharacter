
package student2;

import java.util.Scanner;


public class Student2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap mot chuoi: ");
        
        if (scanner. hasNextLine()) {
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                System.out.println("Chuoi nhap vao la rong: ");
            }else{
                System.out.println ("Chuoi nhap vao: " + input);
            }
        }
        scanner.close();
        // TODO code application logic here
    }
    
}
