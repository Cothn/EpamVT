package Interface.impl.console;

import Interface.LibraryObjEditInterface;
import beans.Book;
import beans.LibraryObj;

import java.util.Scanner;

public class BookEditInterface implements LibraryObjEditInterface {
    @Override
    public LibraryObj ShowEditInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author Id:");
        int authorId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter publishing house Id:");
        int publishingHouseId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter number of pages:");
        int pagesNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter ISBN:");
        String ISBN = scanner.nextLine();
        return new Book(authorId, title, publishingHouseId, pagesNum,  description, genre, ISBN);
    }
}
