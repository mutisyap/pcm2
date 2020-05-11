package tech.meliora.learn.simple.processor;

import tech.meliora.learn.domain.RequestDTO;
import tech.meliora.learn.simple.rud.Processor;

public class PreProcessor implements Processor<RequestDTO> {
    @Override
    public void process(RequestDTO requestDTO) {
        System.out.println("Processing " + requestDTO +" By "+Thread.currentThread().getName());
    }
}
