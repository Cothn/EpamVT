/**
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
*/

package beans;

/**
 * Хранит описание статьи
 */
public class Article extends LibraryObj {
    /** Тема статьи */
    private String Topic;
    /** Обьект исследования */
    private String Subject;

    public Article() {
    }


    /**
     * Конструктор нового описания статьи
     * @param id идентификатор
     * @param authorId идентификатор автора
     * @param title название
     * @param publishingHouseId идентификатор издательства
     * @param pagesNum число страниц
     * @param description описание
     * @param topic тема
     * @param subject обьект исследования
     */
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

    public String getSubject() {
        return Subject;
    }

    /**
     * Генерация строкового представления обьекта
     * @return Строковое представление описания статьи
     */
    @Override
    public String StringView() {

        String result;
        result = String.format("Article| id: %-10d| ",this.getId());
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
        result += String.format(" Numbers of page: %-6d | Topic: %-20s| Subject: %-16s|  description: %-40s|", this.getPagesNum(), Topic, Subject, this.getDescription());
        return result;
    }
}
