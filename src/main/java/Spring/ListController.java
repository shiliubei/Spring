package Spring;


import Spring.domain.WordList;
import Spring.repos.WordListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@Controller
public class ListController {

    @Autowired
    private WordListRepo wordListRepo;

    @GetMapping("/word_list/{id}")
    public String word_list (Map<String, Object> model, @PathVariable("id") Integer id) {
        WordList word = wordListRepo.findById(id).get();
        model.put("list", word);
        return "list";
    }
}
