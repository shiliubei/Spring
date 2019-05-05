package Spring;


import Spring.domain.Word;
import Spring.domain.WordList;
import Spring.repos.WordListRepo;
import Spring.repos.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/word_list/{id}/train_words")
    public String train_words(Map<String, Object> model, @PathVariable("id") Integer listId) {
        WordList wordList = wordListRepo.findById(listId).get();
        model.put("list", wordList); //В этой строке мы присваивае. Ключу list объект из переменной word,экземпляр класса WordList
        //Шаблонизатор использует этот Map в момент когда надо отрендерить шаблон.
        //Он получает из него данные, которые нужны для отрисовки. А запрашивает их по ключам
        return "train_words";
    }

    @GetMapping("/word_list/{id}")
    public String word_list(Map<String, Object> model, @PathVariable("id") Integer listId) {
        WordList word = wordListRepo.findById(listId).get();
        model.put("list", word);
        return "list";
    }

    @RequestMapping(value = "/word_list/{id}/add_word", method = {RequestMethod.GET})
    public String filter(@PathVariable("id") Integer listId, @RequestParam(name = "filter", required = false) final String filter, Map<String, Object> model) {
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

    @RequestMapping(value = "/word_list/{list_id}/add_word",
            method = {RequestMethod.POST})
    public String addWordToList
            (@PathVariable("list_id") Integer wordListId,  //переменная Id списка
             @RequestParam("word_id") Integer wordId,  //переменная Id слова
             Map<String, Object> model) {
        WordList wordList = wordListRepo.findById(wordListId).get();
        Word word = wordRepo.findById(wordId).get();
        wordList.getWords().add(word);
        wordListRepo.save(wordList);
        model.put("list", wordList);
        return "list";
    }
}
