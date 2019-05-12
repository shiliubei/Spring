package Spring.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Word() {

    }

    public Word(String text, String translation) {
        this.text = text;
        this.translation = translation;
    }

    private String text;

    private String translation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
