package nl.rubix.kafka;

import nl.rubix.avro.Location;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer
{
    public static void main(String[] args)
    {
        Producer producer = new Producer();
        producer.ProduceIteration();

//        Producer producer2 = new Producer();
//        producer2.TestLocation();
    }

    public void ProduceIteration()
    {
        int amountMessages = 10; // 10 is enough for the demo

        Properties props = new Properties();
//        props.put("acks", "all");
//        props.put("batch.size", 16384);
        props.put("bootstrap.servers", "localhost:9092");
//        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("linger.ms", 1);
//        props.put("metadata.broker.list", "localhost:9092");
//        props.put("retries", 0);
//        props.put("request.required.acks", "1");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for(int i = 1; i <= amountMessages; i++)
        {
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("testIteration", Integer.toString(i), Integer.toString(i));
            System.out.println ("Publish message " + Integer.toString(i) + " - " + data);
            producer.send(data);
        }

        producer.close();
    }

    public void TestLocation()
    {
        Location location = new Location();
        location.setVehicleId("1");
        location.setTimestamp(System.currentTimeMillis() / 1000L);
        location.setLatitude(51.687402);
        location.setLongtitude(5.307759);
        System.out.println("Generated message " + location.toString());

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", "2", location.toString());
        producer.send(record);
        producer.close();
    }

}