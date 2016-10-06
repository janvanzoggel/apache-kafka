package nl.rubix.kafka;

import nl.rubix.avro.Location;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerAvroString
{
    public static void main(String[] args)
    {
        KafkaProducerAvroString producer = new KafkaProducerAvroString();
        producer.ProduceLocation();
    }

    public void ProduceLocation()
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

        org.apache.kafka.clients.producer.Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", "2", location.toString());
        producer.send(record);
        producer.close();
    }

}