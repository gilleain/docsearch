package docsearch.source;

import java.util.Iterator;
import java.util.List;

import docsearch.model.Document;

public class MemoryDocumentSource implements DocumentSource {
    
    private List<Document> documents;
    
    public MemoryDocumentSource(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public Iterator<Document> iterator() {
        return documents.iterator();
    }

}
