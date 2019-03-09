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

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class ListController {

    @Autowired
    private WordListRepo wordListRepo;
    @Autowired
    private WordRepo wordRepo;

    @GetMapping("/word_list/{id}")
    public String word_list(Map<String, Object> model, @PathVariable("id") Integer listId) {
        WordList word = wordListRepo.findById(listId).get();
        model.put("list", word);
        return "list";
    }

    @GetMapping("/word_list/{id}/add_word")
    public String add_word(@PathVariable("id") Integer listId, Map<String, Object> model) {
        model.put("wordList", wordListRepo.findById(listId).get());
        return "add_word";
    }

    @PostMapping("/word_list/{id}/add_word/filter")
    public String filter(@PathVariable("id") Integer listId, @RequestParam final String filter, Map<String, Object> model) {
        Iterable<Word> words;

        if (filter != null && !filter.isEmpty()) {
            words = StreamSupport.stream(wordRepo.findAll().spliterator(), false)
                    .filter(w -> w.getTranslation().contains(filter)).collect(Collectors.toList());
        } else {
            words = wordRepo.findAll();
        }

        model.put("words", words);
        model.put("filter", filter);
        model.put("wordList", wordListRepo.findById(listId).get());
        return "add_word";
    }
}
