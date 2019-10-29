/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import beans.Author;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link Author}
 */
public class AuthorEditInterfaceImpl implements Interface.AuthorEditInterface {

    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link Author}
     * @return созданный обьект
     */
    @Override
    public Author showEditInterface() {
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
