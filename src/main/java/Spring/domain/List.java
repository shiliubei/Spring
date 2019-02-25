package Spring.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lists")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public List( ) {
    }

    public List(String name) {
        this.name = name;
    }
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    // в шаблоне прописать
    //<a th:href="list/{list.id}"> {list.name}</a>
    @ManyToMany
    private Set<Word> words = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
