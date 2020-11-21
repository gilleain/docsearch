package docsearch.pipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SourceConnector<T> {
    
    private final Input<T> source;
    
    private Iterator<T> sourceIter;
    
    private final List<Output<T>> outputs = new ArrayList<>();
    
    public static <T> SourceConnector<T> connect(Input<T> input, Output<T> output) {
        SourceConnector<T> connector = new SourceConnector<>(input);
        connector.addOutput(output);
        return connector;
    }
    
    public SourceConnector(Input<T> source) {
        this.source = source;
    }
    
    public void addOutput(Output<T> output) {
        this.outputs.add(output);
    }
    
    public void runOne() {
        if (sourceIter == null) {
            sourceIter = source.iterator();
        }
        if (sourceIter.hasNext()) {
            T next = sourceIter.next();
            for (Output<T> output : outputs) {
                output.accept(next);
            }
        }
    }

}
