package docsearch.pipes;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    
    private final SourceConnector<?> source;
    
    private final List<Connector<?>> rest;
    
    public Flow(SourceConnector<?> source) {
        this.source = source;
        this.rest = new ArrayList<>();
    }
    
    public void add(Connector<?> connector) {
        this.rest.add(connector);
    }
    
    /**
     * Run all the documents from the source through the flow.
     */
    public void runAll() {
        
    }
    
    /**
     * Take the first document from the source, and run it through the flow.
     */
    public void runOne() {
        this.source.runOne();
        for (Connector<?> connector : rest) {
            connector.run();
        }
    }

}
