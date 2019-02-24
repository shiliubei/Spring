package Spring;

import Spring.domain.List;
import Spring.repos.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ListController {
    @Autowired
    private ListRepo listsRepo;

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<List> lists = listsRepo.findAll();
        model.put("lists", lists);
        return "main";
    }
    @PostMapping
    public String add ( @RequestParam String list_name, Map <String, Object> model){
       List list = new List(list_name);
        listsRepo.save(list);
        Iterable<List> lists = listsRepo.findAll();
        model.put("lists", lists);
        return "main";
    }

}