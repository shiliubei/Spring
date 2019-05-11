package Spring;

import Spring.domain.WordList;
import Spring.domain.User;
import Spring.repos.UserRepo;
import Spring.repos.WordListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private WordListRepo listsRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<WordList> lists = listsRepo.findAll();
        model.put("lists", lists);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {
        User user = userRepo.findById(1);
        WordList wordList = new WordList(name, user);
        listsRepo.save(wordList);
        Iterable<WordList> lists = listsRepo.findAll();
        model.put("lists", lists);
        return "main";
    }

}