package Spring.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class WordStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Value("${WordStatus.hieroglyph_translation_training:false}")
    @Column(name = "hieroglyph_translation_training", nullable = false)
    private boolean hieroglyph_translation_training;

    @OneToOne
    private Word word;

    public WordStatus() {

    }

    public WordStatus(boolean hieroglyph_translation_training) {
        this.hieroglyph_translation_training = hieroglyph_translation_training;
    }

    public Integer getId() {
        return id;
    }

    public boolean getHieroglyph_translation_training() {
        return hieroglyph_translation_training;
    }

    public Word getWord() {
        return word;
    }
}
