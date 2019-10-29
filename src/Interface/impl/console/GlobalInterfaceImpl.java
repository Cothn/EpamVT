/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */
package Interface.impl.console;

import Interface.*;
import beans.*;
import service.ServiceFactory;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Хранит консольный интерфейс главного меню
 */
public class GlobalInterfaceImpl {

    /**
     * Выводит на консоль интерфейс главного меню
     */
    public void Show() {
        boolean FExit = false;
        Scanner scanner = new Scanner(System.in);

        while (!FExit) {
            System.out.println("What are you want?");
            System.out.println("1. See library list");
            System.out.println("2. See authors list");
            System.out.println("3. See publishing house list");
            System.out.println("4. See employer list");
            System.out.println("5. See Author by id");
            System.out.println("6. Exit");

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
                    ShowPublishingHouse();
                    break;
                }
                case "4": {
                    ShowEmployers();
                    break;
                }
                case "5": {
                    ShowObject();
                    break;
                }
                case "6": {
                    FExit = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }

    }

    /**
     * Выводит на консоль обьект по Id
     */
    private void  ShowObject()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Author id: ");
        if (scanner.hasNextInt()) {
            int objectId = scanner.nextInt();
            scanner.nextLine();
            MyPerentClass obj = ServiceFactory.getAuthorService().getAuthor(objectId);

            if (obj != null) {
                System.out.println(obj.stringView());
            } else {
                System.out.println("Incorrect Author id");
            }
        }
        else
        {
            System.out.println("Incorrect library object id");
        }
    }

    /**
     * Выводит на консоль интерфейс взаимодействия с библиотекой
     */
    private void ShowLibrary(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book List");
        for (LibraryObj library: ServiceFactory.getLibraryService().getAllLibraryObj() ) {
            System.out.println(library.stringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit library object");
            System.out.println("2. Delete library object");
            System.out.println("3. Create library object");
            System.out.println("4. Find by author");
            System.out.println("5. Find by publishing house");
            System.out.println("6. Sort by title");
            System.out.println("7. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "0":
                {
                    System.out.println("Book List");
                    for (LibraryObj library: ServiceFactory.getLibraryService().getAllLibraryObj() ) {
                        System.out.println(library.stringView());
                    }
                    break;
                }
                case "1": {

                    System.out.println("Enter library object id: ");
                    if (scanner.hasNextInt()) {
                        int libraryObjectId = scanner.nextInt();
                        scanner.nextLine();
                        if (ServiceFactory.getLibraryService().getLibraryObj(libraryObjectId) == null) {
                            System.out.println("Incorrect library object id");
                            continue;//break
                        }

                        System.out.println("Enter library object type(Comics/Book/Article): ");
                        String libraryObjectType = scanner.nextLine();
                        LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.getEditInterface(libraryObjectType);
                        if (libraryObjEditInterface == null) {
                            System.out.println("Incorrect library object type");
                            continue;
                        }

                        LibraryObj libraryObj = libraryObjEditInterface.showEditInterface();
                        libraryObj.setId(libraryObjectId);
                        ServiceFactory.getLibraryService().update(libraryObjectId, libraryObj);
                    }
                    else
                    {
                        scanner.nextLine();//
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Enter library object id: ");
                    if (scanner.hasNextInt()) {
                        int libraryObjId = scanner.nextInt();
                        scanner.nextLine();
                        ServiceFactory.getLibraryService().deleteLibraryObjById(libraryObjId);
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "3": {
                    System.out.println("Enter library object type(Comics/Book/Article): ");
                    String libraryObjType = scanner.nextLine();
                    LibraryObjEditInterface libraryObjEditInterface = LibraryObjEditFactory.getEditInterface(libraryObjType);
                    if(libraryObjEditInterface == null)
                    {
                        System.out.println("Incorrect library object type");
                        continue;
                    }
                    LibraryObj libraryObj = libraryObjEditInterface.showEditInterface();
                    ServiceFactory.getLibraryService().addLibraryObj(libraryObj);
                    break;
                }
                case "4": {
                    System.out.println("Enter author id: ");
                    if (scanner.hasNextInt()) {
                        int authorId = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<LibraryObj> goodLibraryObj = (ArrayList<LibraryObj>)ServiceFactory.getLibraryService().findByAuthor(authorId);
                        if (goodLibraryObj.size() == 0) {
                            System.out.println("library object not found");
                            continue;
                        }
                        for (LibraryObj libraryobj : goodLibraryObj) {
                            System.out.println(libraryobj.stringView());
                        }
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "5": {
                    System.out.println("Enter publishing house id: ");
                    if (scanner.hasNextInt()) {
                        int objId = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList<LibraryObj> goodLibraryObj = (ArrayList<LibraryObj>)ServiceFactory.getLibraryService().findByPublishingHouse(objId);
                        if (goodLibraryObj.size() == 0) {
                            System.out.println("library object not found");
                            continue;
                        }
                        for (LibraryObj libraryobj : goodLibraryObj) {
                            System.out.println(libraryobj.stringView());
                        }
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "6":
                {
                    boolean ascending ;
                    System.out.println("Enter as - fo ascending sort and des-fo descending: ");
                    chosenNumber= scanner.nextLine();
                    if (chosenNumber.equals("as"))
                    {
                        ascending = true;
                    }
                    else {
                        if (chosenNumber.equals("des"))
                        {
                            ascending = false;
                        }
                        else
                        {
                            break;
                        }

                    }
                    ArrayList<LibraryObj> sortObjs= (ArrayList<LibraryObj>)ServiceFactory.getLibraryService().sortByTitle(ascending);
                    for (LibraryObj sortObj: sortObjs ) {
                        System.out.println(sortObj.stringView());
                    }

                    break;
                }
                case "7":
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

    /**
     * Выводит на консоль интерфейс взаимодействия с авторами
     */
    private void ShowAuthors(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Author List");
        for (Author author: ServiceFactory.getAuthorService().getAllAuthor() ) {
            System.out.println(author.stringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit author");
            System.out.println("2. Delete author");
            System.out.println("3. Create author");
            System.out.println("4. Find by name");
            System.out.println("5. Sort by name");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "0":
                {
                    System.out.println("Author List");
                    for (Author author: ServiceFactory.getAuthorService().getAllAuthor() ) {
                        System.out.println(author.stringView());
                    }
                    break;
                }
                case "1": {

                        System.out.println("Enter author id: ");
                    if (scanner.hasNextInt()) {
                        int authorId = scanner.nextInt();
                        scanner.nextLine();
                        if (ServiceFactory.getAuthorService().getAuthor(authorId) == null) {
                            System.out.println("Incorrect author id");
                            continue;
                        }


                        AuthorEditInterface authorEditInterface = new AuthorEditInterfaceImpl();
                        Author author = authorEditInterface.showEditInterface();
                        author.setId(authorId);
                        ServiceFactory.getAuthorService().update(authorId, author);
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "2": {

                        System.out.println("Enter author id: ");
                    if (scanner.hasNextInt()) {
                        int authorId = scanner.nextInt();
                        scanner.nextLine();
                        ServiceFactory.getAuthorService().deleteAuthorById(authorId);
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "3": {

                    AuthorEditInterface authorEditInterface = new AuthorEditInterfaceImpl();
                    Author author = authorEditInterface.showEditInterface();
                    ServiceFactory.getAuthorService().addAuthor( author);
                    break;
                }
                case "4": {

                    System.out.println("Enter author name: ");
                    String line= scanner.nextLine();
                    ArrayList<Author> goodObjs= (ArrayList<Author>)ServiceFactory.getAuthorService().findByName(line);
                    if(goodObjs.size() == 0)
                    {
                        System.out.println("authors not found");
                        continue;
                    }
                    for (Author goodObj: goodObjs ) {
                        System.out.println(goodObj.stringView());
                    }

                    break;
                }
                case "5": {
                    boolean ascending;
                    System.out.println("Enter as - fo ascending sort and des-fo descending: ");
                    chosenNumber= scanner.nextLine();
                    if (chosenNumber.equals("as"))
                    {
                        ascending = true;
                    }
                    else {
                        if (chosenNumber.equals("des"))
                        {
                            ascending = false;
                        }
                        else
                        {
                            break;
                        }

                    }
                    ArrayList<Author> sortObjs= (ArrayList<Author>)ServiceFactory.getAuthorService().sortByName(ascending);
                    for (Author sortObj: sortObjs ) {
                        System.out.println(sortObj.stringView());
                    }
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

    /**
     * Выводит на консоль интерфейс взаимодействия с сотрудниками
     */
    private void ShowEmployers(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Employer List");
        for (Employer obj: ServiceFactory.getEmployerService().getAllEmployer() ) {
            System.out.println(obj.stringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit employer");
            System.out.println("2. Delete employer");
            System.out.println("3. Create employer");
            System.out.println("4. Find by position");
            System.out.println("5. Sort by name");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "0":
                {
                    System.out.println("Employer List");
                    for (Employer obj: ServiceFactory.getEmployerService().getAllEmployer() ) {
                        System.out.println(obj.stringView());
                    }
                    break;
                }
                case "1": {

                    System.out.println("Enter employer id: ");
                    if (scanner.hasNextInt()) {
                        int objId = scanner.nextInt();
                        scanner.nextLine();
                        if (ServiceFactory.getEmployerService().getEmployer(objId) == null) {
                            System.out.println("Incorrect employer id");
                            continue;
                        }


                        EmployerEditInterface employerEditInterface = new EmployerEditInterfaceImpl();
                        Employer obj = employerEditInterface.showEditInterface();
                        obj.setId(objId);
                        ServiceFactory.getEmployerService().update(objId, obj);
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Enter employer id: ");
                    if (scanner.hasNextInt()) {
                        int objId = scanner.nextInt();
                        scanner.nextLine();
                        ServiceFactory.getEmployerService().deleteEmployerById(objId);
                    }
                    else
                    {
                        System.out.println("Incorrect value!");
                    }
                    break;
                }
                case "3": {

                    EmployerEditInterface editInterface = new EmployerEditInterfaceImpl();
                    Employer employer = editInterface.showEditInterface();
                    ServiceFactory.getEmployerService().addEmployer(employer);
                    break;
                }
                case "4": {
                    System.out.println("Enter employer position: ");
                    String position= scanner.nextLine();
                    ArrayList<Employer> goodObjs= (ArrayList<Employer>)ServiceFactory.getEmployerService().findByPosition(position);
                    if(goodObjs.size() == 0)
                    {
                        System.out.println("employers not found");
                        continue;
                    }
                    for (Employer goodObj: goodObjs ) {
                        System.out.println(goodObj.stringView());
                    }


                    break;
                }
                case "5": {
                    boolean ascending;
                    System.out.println("Enter as - fo ascending sort and des-fo descending: ");
                    chosenNumber= scanner.nextLine();
                    if (chosenNumber.equals("as"))
                    {
                        ascending = true;
                    }
                    else {
                        if (chosenNumber.equals("des"))
                        {
                            ascending = false;
                        }
                        else
                        {
                            break;
                        }

                    }
                    ArrayList<Employer> sortObjs= (ArrayList<Employer>)ServiceFactory.getEmployerService().sortByName(ascending);
                    for (Employer sortObj: sortObjs ) {
                        System.out.println(sortObj.stringView());
                    }
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

    /**
     * Выводит на консоль интерфейс взаимодействия с издательствами
     */
    private void ShowPublishingHouse(){
        boolean endAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Publishing house List");
        for (PublishingHouse obj: ServiceFactory.getPublishingHouseService().getAllPublishingHouse() ) {
            System.out.println(obj.stringView());
        }
        while (!endAction) {
            System.out.println("What are you want?");
            System.out.println("1. Edit publishing house");
            System.out.println("2. Delete publishing house");
            System.out.println("3. Create publishing house");
            System.out.println("4. Find publishing house by title");
            System.out.println("5. Sort by title");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "0":
                {
                    System.out.println("Publishing house List");
                    for (PublishingHouse obj: ServiceFactory.getPublishingHouseService().getAllPublishingHouse() ) {
                        System.out.println(obj.stringView());
                    }
                    break;
                }
                case "1": {

                    System.out.println("Enter publishing house id: ");
                    int objId= scanner.nextInt();
                    scanner.nextLine();
                    if(ServiceFactory.getPublishingHouseService().getPublishingHouse(objId) == null )
                    {
                        System.out.println("Incorrect publishing house id");
                        continue;
                    }



                    PublishingHouseEditInterface editInterface = new PublishingHouseEditInterfaceImpl();
                    PublishingHouse obj = editInterface.showEditInterface();
                    obj.setId(objId);
                    ServiceFactory.getPublishingHouseService().update(objId,obj);
                    break;
                }
                case "2": {
                    System.out.println("Enter publishing house id: ");
                    int objId = scanner.nextInt();
                    scanner.nextLine();
                    ServiceFactory.getPublishingHouseService().deletePublishingHouseById(objId);
                    break;
                }
                case "3": {

                    PublishingHouseEditInterface editInterface = new PublishingHouseEditInterfaceImpl();
                    PublishingHouse publishingHouse = editInterface.showEditInterface();
                    ServiceFactory.getPublishingHouseService().addPublishingHouse(publishingHouse);
                    break;
                }
                case "4": {
                    System.out.println("Enter publishing house title: ");
                    String title= scanner.nextLine();
                    ArrayList<PublishingHouse> goodPublishingHouse= (ArrayList<PublishingHouse>)ServiceFactory.getPublishingHouseService().findByTitle(title);
                    if(goodPublishingHouse.size() == 0)
                    {
                        System.out.println("publishing house not found");
                        continue;
                    }
                    for (PublishingHouse publishingHouse: goodPublishingHouse ) {
                        System.out.println(publishingHouse.stringView());
                    }


                    break;
                }
                case "5": {
                    boolean ascending;
                    System.out.println("Enter as - fo ascending sort and des-fo descending: ");
                    chosenNumber= scanner.nextLine();
                    if (chosenNumber.equals("as"))
                    {
                        ascending = true;
                    }
                    else {
                        if (chosenNumber.equals("des"))
                        {
                            ascending = false;
                        }
                        else
                        {
                            break;
                        }

                    }
                    ArrayList<PublishingHouse> sortObjs= (ArrayList<PublishingHouse>)ServiceFactory.getPublishingHouseService().sortByTitle(ascending);
                    for (PublishingHouse sortObj: sortObjs ) {
                        System.out.println(sortObj.stringView());
                    }
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

