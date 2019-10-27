package beans;

import java.util.Calendar;

public class Article extends LibraryObj {

    private String Topic;
    private String Subject;

    public Article() {

    }

    public Article(Author author, String title, PublishingHouse publishingHouse, Calendar birthDate, String description,  String topic, String subject) {
        Topic = topic;
        Subject = subject;
    }



    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
