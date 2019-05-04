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

    public WordStatus() {

    }

    public WordStatus(boolean hieroglyphTranslationTraining) {
        this.hieroglyphTranslationTraining = hieroglyphTranslationTraining;
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
