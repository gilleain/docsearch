package docsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    
    private List<Sentence> sentences = new ArrayList<>();
    
    public Paragraph(Sentence... sentencesVar) {
        for (Sentence sentence : sentencesVar) {
            sentences.add(sentence);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence);
        }
        return sb.toString();
    }

}
