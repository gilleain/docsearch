package docsearch.pipes;

public class Printer<T> implements Output<T> {

    @Override
    public void accept(T t) {
        System.out.println(t);
    }

}
