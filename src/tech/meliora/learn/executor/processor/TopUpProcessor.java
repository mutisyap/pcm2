package tech.meliora.learn.executor.processor;

import tech.meliora.learn.domain.RequestDTO;

import java.util.Optional;
import java.util.Properties;

public class TopUpProcessor extends Procesor<RequestDTO> {

    private static TopUpProcessor topUpProcessor;

    public TopUpProcessor(int threads, Properties properties) {
        super(threads, properties);
    }

    /*public static Optional<TopUpProcessor> getInstance() {
        if (topUpProcessor == null) {
            return Optional.empty();
        }
        return Optional.of(topUpProcessor);
    }*/

    /*public static TopUpProcessor createInstance(int threads, Properties properties) {
        if (topUpProcessor == null) {
            topUpProcessor = new TopUpProcessor(threads, properties);
        }
        return topUpProcessor;
    }*/

    @Override
    public void process(RequestDTO requestDTO) {
        System.out.println("Processing " + requestDTO + " Using thread " + Thread.currentThread().getName());
    }

    @Override
    public void init(Properties properties) {
        System.out.println("Initing");
    }
}
