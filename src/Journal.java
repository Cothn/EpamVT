import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Journal extends LibraryObj {

    private int Number;
    private Author Redactor;
    private ArrayList<article> Articles;


    public Journal() {
        super();
    }

    public Journal(int idLibraryObj, String title, Author publichingHouse, Calendar birthDate, String description, int number, Author redactor, ArrayList<article> articles) {
        super(idLibraryObj, title, publichingHouse, birthDate,  description);
        Number = number;
        Redactor = redactor;
        Articles = articles;
    }

    public int getNumber() {
        return Number;
    }


    public void setNumber(int number) {
        Number = number;
    }


    public void setTopic(String topic) {
    }

    public Author getRedactor() {
        return Redactor;
    }

    public void setRedactor(Author redactor) {
        Redactor = redactor;
    }


    public List<article> getArticles() {
        return Articles;
    }

    public void setArticles(ArrayList<article> articles) {
        this.Articles = articles;
    }
}
