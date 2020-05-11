package tech.meliora.learn.simple.rud;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class Service<T> implements Runnable {
    private Queue<T> queue;
    private List<Thread> consumers;
    private String name = "other";

    public abstract void queue(T t);

    public void startConsumers(int consumerCount) {
        if (consumers == null) {
            consumers = new ArrayList<>();
        }

        for (int i = 0; i < consumerCount; i++) {
            Thread consumer = new Thread(this, name + "_consumer_" + i);
            consumer.start();
        }
    }
}
