package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveableDictionary {
    private ArrayList<String> words;
    private ArrayList<String> translations;
    private String file;

    public SaveableDictionary() {
        this(null);
    }

    public SaveableDictionary(String file) {
        this.words = new ArrayList<>();
        this.translations = new ArrayList<>();
        this.file = file;
    }

    public boolean load() {
        try {
            Scanner fileReader = new Scanner(new File(this.file));
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            fileReader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.file));
            for (int i = 0; i < this.words.size(); i++) {
                fileWriter.write(this.words.get(i) + ":" + this.translations.get(i) + "\n");
            }
            // for(Map.Entry<String,String> e:this.dictionary.entrySet() ){
            // fileWriter.write(e.getKey() + ":" + e.getValue())
            // }
            // this.dictionary.entrySet().forEach(
            // (word,translation) -> fileWriter.write(word + ":" + translation)
            // );
            fileWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String words, String translation) {
        // adds a word to the dictionary. Every word has just one translation,
        // and if the same word is added for the second time, nothing happens.
        // if (!this.dictionary.containsKey(words)){
        // this.dictionary.put(words, translation);
        // }
        if (!this.words.contains(words)) {
            this.words.add(words);
            this.translations.add(translation);
        }
    }

    public String translate(String word) {
        // returns the translation for the given word.
        // If the word is not in the dictionary, returns null.
        if (this.words.contains(word)) {
            int i = this.words.indexOf(word);
            return this.translations.get(i);
        }
        if (this.translations.contains(word)) {
            int i = this.translations.indexOf(word);
            return this.words.get(i);
        }
        return null;
        // return this.dictionary.containsKey(word) ? this.dictionary.get(word) : null;
    }

    public void delete(String word) {
        // which deletes the given word and its translation from the dictionary.
        if (this.words.contains(word)) {
            int i = this.words.indexOf(word);
            this.words.remove(i);
            this.translations.remove(i);
        }
        if (this.translations.contains(word)) {
            int i = this.translations.indexOf(word);
            this.words.remove(i);
            this.translations.remove(i);
        }

        // this.dictionary.entrySet().removeIf(
        // entry -> entry.getKey().equals(word) || entry.getValue().equals(word)
        // );

        // if (this.dictionary.containsKey(word)){
        // this.dictionary.remove(word);
        // }
        // if (this.dictionary.values().contains(word)){
        // // habría que iterar el hashmap con un Iterator para borrar
        // }
    }
}
