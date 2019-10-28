package Interface.impl.console;

import Interface.LibraryObjEditInterface;
import beans.Comics;
import beans.LibraryObj;

import java.util.Scanner;

public class ComicsEditInterface implements LibraryObjEditInterface {

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
        System.out.println("Enter drawing:");
        String drawing = scanner.nextLine();
        System.out.println("Enter universe:");
        String universe = scanner.nextLine();
        return new Comics(authorId, title, publishingHouseId, pagesNum,  description, drawing, universe);
    }
}
