package Spring.repos;

import Spring.domain.WordList;
import org.springframework.data.repository.CrudRepository;

public interface WordListRepo extends CrudRepository<WordList, Integer> {

}