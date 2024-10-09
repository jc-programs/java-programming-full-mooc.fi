/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> translations;

    public DictionaryOfManyTranslations() {
        this.translations = new HashMap<>();
    }

    public void add(String word, String translation) {
        // adds the translation for the word and preserves the old translations.
        this.translations.putIfAbsent(word, new ArrayList<>());
        this.translations.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        // returns a list of the translations added for the word. 
        // If the word has no translations, the method should return an empty list.
        if (!this.translations.containsKey(word)) {
            return new ArrayList<>();
        }
        return this.translations.get(word);
    }

    public void remove(String word) {
        // removes the word and all its translations from the dictionary.
        if (this.translations.containsKey(word)) {
            this.translations.remove(word);
        }
    }

}
