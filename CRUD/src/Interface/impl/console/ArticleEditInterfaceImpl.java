/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import Interface.LibraryObjEditInterface;
import beans.Article;
import beans.LibraryObj;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link Article}
 */
public class ArticleEditInterfaceImpl implements LibraryObjEditInterface {
    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link Article}
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
        System.out.println("Enter topic:");
        String Topic = scanner.nextLine();
        System.out.println("Enter subject:");
        String Subject = scanner.nextLine();
        return new Article(authorId, title, publishingHouseId, pagesNum,  description, Topic, Subject);
    }
}
