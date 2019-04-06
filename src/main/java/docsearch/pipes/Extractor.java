package docsearch.pipes;

import java.util.Iterator;
import java.util.List;

public class Extractor<T, S> implements Output<T>, Input<List<S>> {
    
    private T t;

    @Override
    public Iterator<List<S>> iterator() {
        return null;    // TODO
    }

    @Override
    public void accept(T t) {
        this.t = t;
    }

}
