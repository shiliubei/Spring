package Spring.repos;

import Spring.domain.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordRepo extends CrudRepository<Word, Integer> {

    List<Word> findByTranslation (String text);

}
