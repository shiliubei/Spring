package Spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class WordStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean hieroglyphTranslationTraining = false;

    @OneToOne
    private Word word;

    @OneToOne
    private User user;

    public WordStatus() {

    }

    public WordStatus(boolean hieroglyphTranslationTraining, Word word, User user) {
        this.hieroglyphTranslationTraining = hieroglyphTranslationTraining;
        this.word = word;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public boolean getHieroglyphTranslationTraining() {
        return hieroglyphTranslationTraining;
    }

    public Word getWord() {
        return word;
    }
}
