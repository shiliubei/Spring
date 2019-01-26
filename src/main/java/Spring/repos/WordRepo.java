package Spring.repos;

import Spring.domain.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepo extends CrudRepository<Word, Integer> {
}
