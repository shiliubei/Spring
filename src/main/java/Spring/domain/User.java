package Spring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int login;

    private String email;

    private String name;

    public User() {

    }

    public User(int login, String email, String name) {
        this.login = login;
        this.email = email;
        this.name = name;
    }

    public int getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
