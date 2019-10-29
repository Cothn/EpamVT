/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import beans.Employer;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link Employer}
 */
public class EmployerEditInterfaceImpl implements Interface.EmployerEditInterface {

    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link Employer}
     * @return созданный обьект
     */
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
