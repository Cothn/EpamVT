import Interface.impl.console.MainInterface;
import beans.*;

import java.util.List;
import java.util.Scanner;

public class Aplication {
    public static Scanner in;

    public static void main(String[] args) {

        MainInterface mainInterface = new MainInterface();
        mainInterface.Show();
        System.out.println("End");
       /* in = new Scanner(System.in);//start read


        Book book = new Book();
        book.setId(1);
        book.setTitle("BookTitle");
        books = new ArrayList<Book>();
        books.add(book);
        employers = new ArrayList<Employee>();
        libraryCards = new ArrayList<LibraryCard>();
        articles = new ArrayList<Article>();
        authors = new ArrayList<Author>();
        publishingHouses = new ArrayList<PublishingHouse>();
        AllCommand();


        MainInterface consoleView = new MainInterface();
        consoleView.Show();
        System.out.println("End");

        in.close();*/
    }
/*
    public static void AllCommand()
    {
        Boolean close = false;
        String command = "";

        while (close != true) {
            System.out.print("Input command: ");
            command = in.nextLine();
            switch (command) {
                case "help":
                    System.out.print("help: command list \nClose: close program \nShow lists: show all list in library with kol element\n");
                    break;
                case "Close":
                    close = true;
                    break;
                case "Show lists":
                    System.out.printf("Books - %d\nEmployers - %d\n", books.size(), employers.size());
                    break;

            }
        }

    }*/
}
