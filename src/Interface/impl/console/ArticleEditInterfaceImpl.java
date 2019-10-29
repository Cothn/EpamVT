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
        System.out.println("Enter topic:");
        String Topic = scanner.nextLine();
        System.out.println("Enter subject:");
        String Subject = scanner.nextLine();
        return new Article(authorId, title, publishingHouseId, pagesNum,  description, Topic, Subject);
    }
}
