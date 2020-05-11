package tech.meliora.learn.simple.service;

import tech.meliora.learn.domain.RequestDTO;
import tech.meliora.learn.simple.rud.Processor;
import tech.meliora.learn.simple.rud.Service;

import java.util.LinkedList;
import java.util.Queue;

public class PreService extends Service<RequestDTO> {
    private final Queue<RequestDTO> queue = new LinkedList<>();
    private final Processor<RequestDTO> processor;

    public PreService(Processor<RequestDTO> processor, int consumerCount) {
        this.processor = processor;

        this.startConsumers(consumerCount);
    }

    @Override
    public void queue(RequestDTO requestDTO) {
        this.queue.add(requestDTO);
        synchronized (queue) {
            this.queue.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                RequestDTO requestDTO = null;
                if (!queue.isEmpty()) {
                    requestDTO = queue.poll();
                }

                if (requestDTO != null) {
                    processor.process(requestDTO);
                } else {
                    synchronized (queue) {
                        queue.wait();
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
//                System.out.println("Encountered exception"+ ex);
            }
        }
    }
}
