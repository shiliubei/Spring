package Spring;

import Spring.domain.Word;
import Spring.repos.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private WordRepo wordsRepo;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Word> words = wordsRepo.findAll();
        model.put("words", words);
        return "main";
    }
    @PostMapping
    public String add (@RequestParam String text, @RequestParam String translation, Map <String, Object> model){
       Word word = new Word(text, translation);
       wordsRepo.save(word);
        Iterable<Word> words = wordsRepo.findAll();
        model.put("words", words);
        return "main";
    }

}