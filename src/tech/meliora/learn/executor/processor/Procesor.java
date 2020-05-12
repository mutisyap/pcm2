package tech.meliora.learn.executor.processor;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Procesor<T> {
    private ExecutorService executorService;

    protected Procesor(int threads, Properties properties) {
        executorService = Executors.newFixedThreadPool(threads);
        init(properties);
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public abstract void process(T t);
    public abstract void init(Properties properties);

    public void queue(T t) {
        /*if (executorService == null) {
            executorService = Executors.newFixedThreadPool(10);
        }*/

        // start time
        executorService.execute(() -> process(t));

        // report process
    }

    public void shutDown(){
        if (this.executorService != null){
            this.executorService.shutdown();
        }
    }
}
