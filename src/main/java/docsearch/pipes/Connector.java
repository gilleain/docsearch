package docsearch.pipes;

import java.util.ArrayList;
import java.util.List;

public class Connector<T> {
    
    private List<Input<T>> inputs = new ArrayList<>();
    
    private List<Output<T>> outputs = new ArrayList<>();
    
    public static <T> Connector<T> connect(Input<T> input, Output<T> output) {
        Connector<T> connector = new Connector<>();
        connector.addInput(input);
        connector.addOutput(output);
        return connector;
    }
    
    public void addInput(Input<T> input) {
        this.inputs.add(input);
    }
    
    public void addOutput(Output<T> output) {
        this.outputs.add(output);
    }
    
    public void run() {
        for (Input<T> input : inputs) {
            for (T t : input) {
                for (Output<T> output : outputs) {
                    output.accept(t);
                }
            }
        }
    }
}
