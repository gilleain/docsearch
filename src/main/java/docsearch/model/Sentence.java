package docsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    
    private List<Word> words = new ArrayList<>();
    
    public Sentence(Word... wordsVar) {
        for (Word word : wordsVar) {
            words.add(word);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Word word : words) {
            if (index < words.size() - 1) {
                sb.append(word).append(" ");
            } else {
                sb.append(word).append(". ");
            }
            index++;
        }
        return sb.toString();
    }

    public List<Word> getWords() {
        return words;
    }

}
