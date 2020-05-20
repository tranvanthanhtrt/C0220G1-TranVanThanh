package controllers;

import models.Dictionary;
import org.omg.CORBA.WStringSeqHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.text.normalizer.NormalizerBase;

@Controller
public class TranslateController {
    Dictionary dictionary=new Dictionary();

    @GetMapping("/translate")
    public String dictionary() {
        return "dictionary";
    }

    @PostMapping("translates")
    public String translates(@RequestParam String word,Model model) {
        String result=dictionary.translate(word);
        model.addAttribute("result",result);
        return "result";
    }
}
