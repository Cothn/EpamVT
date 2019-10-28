package beans;

import java.util.Calendar;

public class Article extends LibraryObj {

    private String Topic;
    private String Subject;

    public Article() {

    }

    public Article(int id, int authorId, String title, int publishingHouseId, int pagesNum, String description,  String topic, String subject) {
        super( id, authorId, title, publishingHouseId, pagesNum,  description);
        Topic = topic;
        Subject = subject;
    }

    public Article(int authorId, String title, int publishingHouseId, int pagesNum, String description,  String topic, String subject) {
        super(authorId, title, publishingHouseId, pagesNum,  description);
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

    @Override
    public String StringView() {

        String result;
        result = String.format("Article| id: %-13d| ",this.getId());
        if (this.getAuthorId() != 0){
            result += String.format(" AuthorId: %-14d| ", this.getAuthorId());
        }
        else
        {
            result += " AuthorId: author unknown| ";
        }
        result += String.format("title: %-20s|", this.getTitle());
        if (this.getPublishingHouseId() != 0){
            result += String.format(" PublishingHouseId: %-24d| ", this.getPublishingHouseId());
        }
        else
        {
            result += " PublishingHouseId: publishing house unknown| ";
        }
        result += String.format(" Numbers of page: %-5d|  Topic: %-20s| Subject: %-13s|  description: %-40s|", this.getPagesNum(), Topic, Subject, this.getDescription());

        return result;
    }
}
