package Spring;


import Spring.domain.Word;
import Spring.domain.WordList;
import Spring.repos.WordListRepo;
import Spring.repos.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class ListController {

    @Autowired
    private WordListRepo wordListRepo;
    @Autowired
    private WordRepo wordRepo;

    @GetMapping("/word_list/{id}")
    public String word_list(Map<String, Object> model, @PathVariable("id") Integer id) {
        WordList word = wordListRepo.findById(id).get();
        model.put("list", word);
        return "list";
    }

    @GetMapping("/word_list/add_word")
    public String add_word(Map<String, Object> model) {
//        Iterable<Word> words = wordRepo.findAll();
//        model.put("words", words);
        return "add_word";
    }

    @PostMapping("/word_list/add_word/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Word> words;

        if (filter != null && !filter.isEmpty()) {
            words = wordRepo.findByTranslation(filter);
        } else {
            words = wordRepo.findAll();
        }

        model.put("words", words);
        model.put("filter", filter);
        return "add_word";
    }
}
