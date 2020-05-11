package tech.meliora.learn.simple.rud;

public interface Processor<T> {
    void process(T t);
}
