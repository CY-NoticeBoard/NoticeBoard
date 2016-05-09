import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * Created by allen7593 on 2016/5/9.
 */
public class RabbitDirect implements RabbitMQ{
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private static RabbitDirect instance;
    private String queueName = "DirectMessage";
    private String host = "localhost";

    private RabbitDirect(String host, String queueName) throws java.io.IOException, TimeoutException {
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

    public static RabbitDirect getInstance(String host, String queueName) throws IOException, TimeoutException {
        if (instance != null){
            return instance;
        }
        return new RabbitDirect(host,queueName);
    }

    public void send(String header,String message) throws IOException {
        if (channel != null){
            channel.basicPublish(header,queueName,null,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    public String recv(){
        String message = null;

        return message;
    }

    public void closeConnection(){

    }
}
