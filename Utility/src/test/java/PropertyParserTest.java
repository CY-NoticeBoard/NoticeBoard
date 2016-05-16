import Utils.PropertyPraser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by allen7593 on 2016/5/16.
 */
public class PropertyParserTest {

    @Before
    public void init() throws IOException {
        PropertyPraser pp = new PropertyPraser();
        pp.readProperties("rabbitmq.properties");
    }

    @Test
    public void getRabbitHost(){
        Assert.assertEquals("localhost",PropertyPraser.getRabbitmqHost());
    }

    @Test
    public void getRabbitUserName(){
        Assert.assertEquals("admin",PropertyPraser.getRabbitmqUsername());
    }

    @Test
    public void getRabbitPassword(){
        Assert.assertEquals("admin",PropertyPraser.getRabbitmqPassword());
    }

    @Test
    public void getRabbitDirectName(){
        Assert.assertEquals("direct",PropertyPraser.getRabbitmqDirectQueueName());
    }

    @Test
    public void getRabbitFanoutName(){
        Assert.assertEquals("fanout",PropertyPraser.getRabbitmqFanoutQueueName());
    }
}
