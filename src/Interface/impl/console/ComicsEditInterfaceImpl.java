/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import Interface.LibraryObjEditInterface;
import beans.Comics;
import beans.LibraryObj;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link Comics}
 */
public class ComicsEditInterfaceImpl implements LibraryObjEditInterface {

    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link Comics}
     * @return созданный обьект
     */
    @Override
    public LibraryObj showEditInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author Id:");
        int authorId;
        if (scanner.hasNextInt()) {
            authorId = scanner.nextInt();
        }
        else
        {
            authorId = 0;
        }
        scanner.nextLine();
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter publishing house Id:");
        int publishingHouseId;
        if (scanner.hasNextInt()) {
            publishingHouseId = scanner.nextInt();
        }
        else
        {
            publishingHouseId = 0;
        }
        scanner.nextLine();
        System.out.println("Enter number of pages:");
        int pagesNum;
        if (scanner.hasNextInt()) {
            pagesNum = scanner.nextInt();
        }
        else
        {
            pagesNum = 1;
        }
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
