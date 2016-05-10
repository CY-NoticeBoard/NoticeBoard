import Interfaces.RabbitMQSender;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * Created by allen7593 on 2016/5/9.
 */
public class RabbitDirectSend implements RabbitMQSender {
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private static RabbitDirectSend instance;
    private String queueName = "DirectMessage";
    private String host = "localhost";

    private RabbitDirectSend(String host, String queueName) throws java.io.IOException, TimeoutException {
        factory = new ConnectionFactory();
        if (host != null && host.length() > 0) {
            this.host = host;
        }
        if (queueName != null && queueName.length() > 0){
            this.queueName = queueName;
        }
        factory.setHost(this.host);
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);
    }

    public static RabbitDirectSend getInstance(String host, String queueName) throws IOException, TimeoutException {
        if (instance != null){
            return instance;
        }
        return new RabbitDirectSend(host,queueName);
    }

    public void send(String header,String message) throws IOException {
        if (channel != null){
            channel.basicPublish(header,queueName,null,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    public void closeConnection() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
