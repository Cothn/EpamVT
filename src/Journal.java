import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Journal extends LibraryObj {

    private int Number;
    private ArrayList<article> Articles;


    public Journal() {
        super();
    }

    public Journal(int idLibraryObj, String title, Author publichingHouse, Calendar birthDate, String description, int number, Author redactor, ArrayList<article> articles) {
        super(idLibraryObj, redactor, title, publichingHouse, birthDate,  description);
        Number = number;
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




    public List<article> getArticles() {
        return Articles;
    }

    public void setArticles(ArrayList<article> articles) {
        this.Articles = articles;
    }
}
