package Interface.impl.console;

import Interface.LibraryObjEditFactory;
import Interface.LibraryObjEditInterface;
import beans.LibraryObj;
import service.ServiceFactory;

import java.util.Scanner;

public class MainInterface {
    public void Show() {
        boolean FExit = false;
        Scanner scanner = new Scanner(System.in);


        while (!FExit) {
            System.out.println("What are you want?");
            System.out.println("1. See library list");
            System.out.println("2. See authors list");
            System.out.println("3. See publishing house list");
            System.out.println("4. See employer list");
            System.out.println("5. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    ShowLibrary();
                    break;
                }
                case "2": {
                   ShowAuthors();
                    break;
                }
                case "3": {
                    // ShowPublishingHouse();
                    break;
                }
                case "4": {
                    // ShowEmployers();
                    break;
                }
                case "5": {
                    FExit = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }

    }


    public void ShowLibrary(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book List");
        for (LibraryObj library: ServiceFactory.getLibraryService().getAllLibraryObj() ) {
            System.out.println(library.StringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit library object");
            System.out.println("2. Delete library object");
            System.out.println("3. Create library object");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {

                    System.out.println("Enter library object id: ");
                    int libraryObjectId= scanner.nextInt();
                    scanner.nextLine();
                    if(ServiceFactory.getLibraryService().getLibraryObj(libraryObjectId) == null )
                    {
                        System.out.println("Incorrect library object id");
                        continue;
                    }

                    System.out.println("Enter library object type(Comics/Book/Article): ");
                    String libraryObjectType = scanner.nextLine();
                    LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.GetEditInterface(libraryObjectType);
                    if(libraryObjEditInterface == null)
                    {
                        System.out.println("Incorrect library object type");
                        continue;
                    }

                    LibraryObj libraryObj = libraryObjEditInterface.ShowEditInterface();
                    libraryObj.setId(libraryObjectId);
                    ServiceFactory.getLibraryService().update(libraryObjectId,libraryObj);
                    break;
                }
                case "2": {
                    System.out.println("Enter library object id: ");
                    int libraryObjId = scanner.nextInt();
                    scanner.nextLine();
                    ServiceFactory.getLibraryService().deleteLibraryObjById(libraryObjId);
                    break;
                }
                case "3": {
                    System.out.println("Enter library object type(Comics/Book/Article): ");
                    String libraryObjType = scanner.nextLine();
                    LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.GetEditInterface(libraryObjType);
                    if(libraryObjEditInterface == null)
                    {
                        System.out.println("Incorrect library object type");
                        continue;
                    }
                    LibraryObj libraryObj = libraryObjEditInterface.ShowEditInterface();
                    ServiceFactory.getLibraryService().addLibraryObj(libraryObj);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6":
                {
                    endAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }       /**/
    }

    public void ShowAuthors(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book List");
        for (LibraryObj library: ServiceFactory.getLibraryService().getAllLibraryObj() ) {
            System.out.println(library.StringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit author");
            System.out.println("2. Delete author");
            System.out.println("3. Create author");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {

                    System.out.println("Enter library object id: ");
                    int libraryObjectId= scanner.nextInt();
                    scanner.nextLine();
                    if(ServiceFactory.getLibraryService().getLibraryObj(libraryObjectId) == null )
                    {
                        System.out.println("Incorrect library object id");
                        continue;
                    }

                    System.out.println("Enter library object type(Comics/Book/Article): ");
                    String libraryObjectType = scanner.nextLine();
                    LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.GetEditInterface(libraryObjectType);
                    if(libraryObjEditInterface == null)
                    {
                        System.out.println("Incorrect library object type");
                        continue;
                    }

                    LibraryObj libraryObj = libraryObjEditInterface.ShowEditInterface();
                    libraryObj.setId(libraryObjectId);
                    ServiceFactory.getLibraryService().update(libraryObjectId,libraryObj);
                    break;
                }
                case "2": {
                    System.out.println("Enter library object id: ");
                    int libraryObjId = scanner.nextInt();
                    scanner.nextLine();
                    ServiceFactory.getLibraryService().deleteLibraryObjById(libraryObjId);
                    break;
                }
                case "3": {
                    System.out.println("Enter library object type(Comics/Book/Article): ");
                    String libraryObjType = scanner.nextLine();
                    LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.GetEditInterface(libraryObjType);
                    if(libraryObjEditInterface == null)
                    {
                        System.out.println("Incorrect library object type");
                        continue;
                    }
                    LibraryObj libraryObj = libraryObjEditInterface.ShowEditInterface();
                    ServiceFactory.getLibraryService().addLibraryObj(libraryObj);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6":
                {
                    endAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }       /**/
    }


}

