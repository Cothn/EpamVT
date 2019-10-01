public class article {

    private Author author;
    private String Topic;
    private String Description;

    public article() {

    }

    public article(Author author, String topic, String description) {
        this.author = author;
        Topic = topic;
        Description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
