package Interface.impl.console;

import beans.PublishingHouse;

import java.util.Scanner;

/**
 * Хранит консольный интерфейс создания обьекта {@link PublishingHouse}
 */
public class PublishingHouseEditInterfaceImpl implements Interface.PublishingHouseEditInterface {

    /**
     * Выводит на консоль интерфейс создания обьекта, и создает обьект {@link PublishingHouse}
     * @return созданный обьект
     */
    @Override
    public PublishingHouse ShowEditInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter foundation date:");
        String FoundationDate = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        return new PublishingHouse(title, address, phone, FoundationDate, description);
    }
}
