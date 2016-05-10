package Interfaces;

import java.io.IOException;

/**
 * Created by allen7593 on 2016/5/10.
 */
public interface RabbitMQSender {
    void send(String header, String message) throws IOException;
}
