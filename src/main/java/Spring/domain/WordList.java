package Spring.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "lists")
public class WordList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Word> words;

    public WordList() {

    }

    public WordList(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Word> getWords() {
        return words;
    }
}
