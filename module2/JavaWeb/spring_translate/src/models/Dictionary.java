package models;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static Map<String,String> dictionarys;
    static {
        dictionarys=new HashMap<>();
        dictionarys.put("hello","xin chào");
        dictionarys.put("dog","thạch");
    }

    public Dictionary() {
    }
    public String translate(String word){
        return dictionarys.get(word);
    }
}
