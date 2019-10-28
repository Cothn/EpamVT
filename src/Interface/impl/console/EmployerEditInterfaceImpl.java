package Interface.impl.console;

import beans.Employer;

import java.util.Scanner;

public class EmployerEditInterfaceImpl implements Interface.EmployerEditInterface {


    @Override
    public Employer ShowEditInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter position:");
        String position = scanner.nextLine();
        return new Employer(name, surname, phone, position);
    }
}
