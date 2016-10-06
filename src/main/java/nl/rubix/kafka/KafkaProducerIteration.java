package nl.rubix.kafka;

import nl.rubix.avro.Location;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerIteration
{
    public static void main(String[] args)
    {
        KafkaProducerIteration producer = new KafkaProducerIteration();
        producer.ProduceIteration();
    }

    public void ProduceIteration()
    {
        int amountMessages = 10; // 10 is enough for the demo

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);

        for(int i = 1; i <= amountMessages; i++)
        {
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i));
            System.out.println ("Publish message " + Integer.toString(i) + " - " + data);
            producer.send(data);
        }

        producer.close();
    }

}