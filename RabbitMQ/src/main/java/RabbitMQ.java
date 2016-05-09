import java.io.IOException;

/**
 * Created by allen7593 on 2016/5/9.
 */
public interface RabbitMQ {
    void send(String header, String message) throws IOException;
    String recv();
}
