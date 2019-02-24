package Spring.repos;

import Spring.domain.List;
import org.springframework.data.repository.CrudRepository;

public interface ListRepo extends CrudRepository<List, Integer> {
}