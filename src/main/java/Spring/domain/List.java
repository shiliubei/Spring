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

    public List() {
    }

    public List(int word_id) {
        this.word_id = word_id;

    }

    @Column(name = "list_name", length = 30, nullable = false)
    private String list_name;
    @Column(name = "word_id", length = 30, nullable = false)
    private int word_id;
    @ManyToMany
    private Set<Word> words = new HashSet<>();

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }


    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }





}
