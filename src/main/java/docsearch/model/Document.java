package docsearch.model;

import java.util.ArrayList;
import java.util.List;

public class Document {
    
    private final List<Paragraph> paragraphs = new ArrayList<>();
    
    public Document(Paragraph... paragraphsVar) {
        for (Paragraph paragraph : paragraphsVar) {
            paragraphs.add(paragraph);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Paragraph paragraph : paragraphs) {
            sb.append(paragraph);
            if (index < paragraphs.size() - 1) {
                sb.append("\n");
            }
            index++;
        }
        return sb.toString();
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

}
