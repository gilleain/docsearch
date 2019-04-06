package docsearch.pipes;

public interface Output<T> {

    void accept(T t);
}
