package Interface.impl.console;

import beans.PublishingHouse;

import java.util.Scanner;

public class PublishingHouseEditInterfaceImpl implements Interface.PublishingHouseEditInterface {

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
