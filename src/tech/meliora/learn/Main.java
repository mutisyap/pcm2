package tech.meliora.learn;

import tech.meliora.learn.domain.RequestDTO;
import tech.meliora.learn.executor.processor.Procesor;
import tech.meliora.learn.executor.processor.TopUpProcessor;
import tech.meliora.learn.simple.processor.PreProcessor;
import tech.meliora.learn.simple.rud.Processor;
import tech.meliora.learn.simple.rud.Service;
import tech.meliora.learn.simple.service.PreService;

import java.util.Optional;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        Processor<RequestDTO> processor = new PreProcessor();
//
//        Service<RequestDTO> service = new PreService(processor, 2);

        /*Optional<TopUpProcessor> topUpProcessorOptional = TopUpProcessor.getInstance(); //  new TopUpProcessor(2, new Properties());
        TopUpProcessor topUpProcessor = null;
        if (topUpProcessorOptional.isPresent()){
            topUpProcessor = topUpProcessorOptional.get();
        } else {
            throw new Exception()
        }*/


        TopUpProcessor topUpProcessor = new TopUpProcessor(2, new Properties());

        RequestDTO requestDTO = new RequestDTO(1L, "testing");
        topUpProcessor.queue(requestDTO);

        // service.queue(requestDTO);

        RequestDTO request2 = new RequestDTO(2L, "testing2");
        topUpProcessor.queue(request2);

        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        topUpProcessor.queue(new RequestDTO(3L, "3"));
        // service.queue(request2);

        topUpProcessor.shutDown();
    }
}
