package Spring.repos;

import Spring.domain.Word;
import org.springframework.data.repository.CrudRepository;

public interface ListRepo extends CrudRepository<Word, Integer> {
}