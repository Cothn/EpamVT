/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import Interface.LibraryObjEditInterface;
import beans.Book;
import beans.LibraryObj;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link Book}
 */
public class BookEditInterfaceImpl implements LibraryObjEditInterface {

    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link Book}
     * @return созданный обьект
     */
    @Override
    public LibraryObj ShowEditInterface() {
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
        System.out.println("Enter genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter ISBN:");
        String ISBN = scanner.nextLine();
        return new Book(authorId, title, publishingHouseId, pagesNum,  description, genre, ISBN);

    }
}
