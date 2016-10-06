//package nl.rubix.kafka;
//
//import nl.rubix.avro.Location;
//import org.apache.avro.Schema;
//import org.apache.avro.file.DataFileStream;
//import org.apache.avro.file.DataFileWriter;
//import org.apache.avro.generic.GenericDatumReader;
//import org.apache.avro.generic.GenericDatumWriter;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.avro.io.DatumReader;
//import org.apache.avro.io.DatumWriter;
//
//import kafka.consumer.ConsumerConfig;
//import kafka.consumer.ConsumerIterator;
//import kafka.consumer.KafkaStream;
//import kafka.javaapi.consumer.ConsumerConnector;
//import kafka.message.MessageAndMetadata;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//
//public class KafkaConsumerAvroByte
//{
//    public static void main(String[] args) throws IOException
//    {
//        Properties props = new Properties();
//        props.put("zookeeper.connect", "localhost:8080");
//        props.put("group.id", "group1");
//        // to read messages from the beginning
//        // first time for every group
//        props.put("auto.offset.reset", "smallest");
//        ConsumerConfig consumerConfig = new ConsumerConfig(props);
//        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
//
//
//        // Decode
//        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>();
//        System.out.println("DECODE reader: " + reader);
//        ByteArrayInputStream is = new ByteArrayInputStream(outputStream.toByteArray());
//        System.out.println("DECODE is: " + is);
//        DataFileStream<GenericRecord> dataFileReader = new DataFileStream<GenericRecord>(is, reader);
//        System.out.println("DECODE dataFileReader: " + dataFileReader);
//
//        GenericRecord record = null;
//        while (dataFileReader.hasNext())
//        {
//            record = dataFileReader.next(record);
//            System.out.println(record.get("vehicle_id").toString());
//            System.out.println(record.get("timestamp").toString());
//            System.out.println(record.get("latitude").toString());
//            System.out.println(record.get("longtitude").toString());
//        }
//
//    }
//}