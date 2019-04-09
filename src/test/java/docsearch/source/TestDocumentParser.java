package docsearch.source;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import docsearch.model.Document;
import docsearch.model.Paragraph;
import docsearch.model.Sentence;

public class TestDocumentParser {
    
    @Test
    public void testParse() {
        String text = "Hello world. This is another sentence.\nStarting another paragraph.";
        
        Document document = DocumentParser.parse(text);
        List<Paragraph> paragraphs = document.getParagraphs();
        assertEquals(2, paragraphs.size());
        
        Paragraph p1 = paragraphs.get(0);
        List<Sentence> p1Sentences = p1.getSentences();
        assertEquals(2, p1Sentences.size());
        
        Sentence s11 = p1Sentences.get(0);
        assertEquals(2, s11.getWords().size());
        
        Sentence s12 = p1Sentences.get(1);
        assertEquals(4, s12.getWords().size());
        
        Paragraph p2 = paragraphs.get(1);
        List<Sentence> s2 = p2.getSentences();
        assertEquals(1, s2.size());
    }

}
