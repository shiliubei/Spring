package Spring.repos;

import Spring.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findByLogin(String login);


}
