package Spring.repos;

import Spring.domain.Word;
import Spring.domain.WordStatus;
import org.springframework.data.repository.CrudRepository;

public interface WordStatusRepo extends CrudRepository<WordStatus, Integer> {

}
