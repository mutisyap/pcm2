package tech.meliora.learn;

import tech.meliora.learn.domain.RequestDTO;
import tech.meliora.learn.simple.processor.PreProcessor;
import tech.meliora.learn.simple.rud.Processor;
import tech.meliora.learn.simple.rud.Service;
import tech.meliora.learn.simple.service.PreService;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Processor<RequestDTO> processor = new PreProcessor();

        Service<RequestDTO> service = new PreService(processor, 2);

        RequestDTO requestDTO = new RequestDTO(1L, "testing");
        service.queue(requestDTO);

        RequestDTO request2 = new RequestDTO(1L, "testing");
        service.queue(request2);
    }
}
