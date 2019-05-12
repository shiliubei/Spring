package Spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String login;

    private String email;

    private String name;

    public User() {

    }

    public User(String login, String email, String name) {
        this.login = login;
        this.email = email;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
