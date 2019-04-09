package docsearch.source;

import docsearch.model.Document;
import docsearch.model.Paragraph;
import docsearch.model.Sentence;
import docsearch.model.Word;

public class DocumentParser {
    
    private DocumentParser() {
        // private constructor to prevent instantiation
    }
    
    public static Document parse(String text) {
        String[] paragraphStrings = text.split("\n");
        Paragraph[] paragraphs = new Paragraph[paragraphStrings.length];
        int index = 0;
        for (String paragraphString : paragraphStrings) {
            paragraphs[index] = parseParagraph(paragraphString);
            index++;
        }
        
        return new Document(paragraphs);
    }
    
    private static Paragraph parseParagraph(String paragraphString) {
        String[] sentenceStrings = paragraphString.split("\\.");
        Sentence[] sentences = new Sentence[sentenceStrings.length];
        int index = 0;
        for (String sentenceString : sentenceStrings) {
            sentences[index] = parseSentence(sentenceString);
            index++;
        }
        return new Paragraph(sentences);
    }

    private static Sentence parseSentence(String sentenceString) {
        String[] wordStrings = sentenceString.trim().split("\\s+");
        Word[] words = new Word[wordStrings.length];
        int index  = 0;
        for (String wordString : wordStrings) {
            words[index] = new Word(wordString);
            index++;
        }
        return new Sentence(words);
    }

}
