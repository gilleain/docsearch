package docsearch.integration;

import static docsearch.pipes.Connector.connect;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import docsearch.model.Document;
import docsearch.model.Paragraph;
import docsearch.pipes.Connector;
import docsearch.pipes.Extractor;
import docsearch.pipes.Filter;
import docsearch.pipes.Printer;
import docsearch.source.DocumentSource;
import docsearch.source.MemoryDocumentSource;

public class ATest {
    
    @Test
    public void testA() {
        List<Document> documentList = new ArrayList<>();
        DocumentSource source = new MemoryDocumentSource(documentList);
        
        Extractor<Document, Paragraph> paragraphExtractor1 = new Extractor<>();
        Extractor<Document, Paragraph> paragraphExtractor2 = new Extractor<>();
        
        Connector<Document> connector1 = connect(source, paragraphExtractor1);
        connector1.addOutput(paragraphExtractor2);
        
        Filter<List<Paragraph>> filter1 = new Filter<>();
        Connector<List<Paragraph>> connector2 = connect(paragraphExtractor1, filter1);
        
        Filter<List<Paragraph>> filter2 = new Filter<>();
        Connector<List<Paragraph>> connector3 = connect(paragraphExtractor2, filter2);
        
        Printer<List<Paragraph>> printer = new Printer<>();
        Connector<List<Paragraph>> connector4 = connect(filter1, printer);
        connector4.addInput(filter2);
        
        connector1.run();
        connector2.run();
        connector3.run();
        connector4.run();
    }

}
