package Interface.impl.console;

import beans.Author;

import java.util.Scanner;

public class AuthorEditInterfaceImpl implements Interface.AuthorEditInterface {
    @Override
    public Author ShowEditInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter birth date:");
        String birthDate = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        return new Author(name, surname, birthDate, description);
    }
}
