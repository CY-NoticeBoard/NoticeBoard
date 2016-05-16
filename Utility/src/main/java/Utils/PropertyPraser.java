package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allen7593 on 2016/5/10.
 */
public class PropertyPraser {
    private final static String RABBITMQ_HOST = "rabbitmq.host";
    private final static String RABBITMQ_USERNAME = "rabbitmq.username";
    private final static String RABBITMQ_PASSWORD = "rabbitmq.password";
    private final static String RABBITMQ_DIRECT_QUEUE_NAME = "rabbit.direct.queue.name";
    private final static String RABBITMQ_FANOUT_QUEUE_NAME = "rabbitmq.fanout.queue.name";

    private static Map<String,String> properties = new HashMap<String, String>();

    public void readProperties(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        FileReader fileReader = new FileReader(classLoader.getResource(fileName).getFile());
        BufferedReader br = new BufferedReader(fileReader);
        try {
            String line = br.readLine();
            while (line!=null){
                String[] split = line.split("=");
                String key = split[0];
                String value = split[1];
                if (!StringUtil.isEmpty(key) && !StringUtil.isEmpty(value)) {
                    properties.put(key, value);
                }
                line = br.readLine();
            }
        }
        finally {
            br.close();
        }
    }

    public static String getRabbitmqHost(){
        return properties.get(RABBITMQ_HOST);
    }

    public static String getRabbitmqDirectQueueName(){
        return properties.get(RABBITMQ_DIRECT_QUEUE_NAME);
    }

    public static String getRabbitmqFanoutQueueName(){
        return properties.get(RABBITMQ_FANOUT_QUEUE_NAME);
    }

    public static String getRabbitmqUsername(){
        return properties.get(RABBITMQ_USERNAME);
    }

    public static String getRabbitmqPassword(){
        return properties.get(RABBITMQ_PASSWORD);
    }
}
