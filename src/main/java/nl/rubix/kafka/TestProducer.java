//package nl.rubix.kafka;
//
//import java.util.*;
//import java.io.ByteArrayOutputStream;
//import java.io.Writer;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.ByteArraySerializer;
//
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericData;
//import org.apache.avro.generic.GenericDatumReader;
//import org.apache.avro.generic.GenericDatumWriter;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.avro.io.DatumReader;
//import org.apache.avro.io.Decoder;
//import org.apache.avro.io.DecoderFactory;
//import org.apache.avro.io.Encoder;
//import org.apache.avro.io.EncoderFactory;
//
//import nl.rubix.avro.Location;
//
//public class TestProducer
//{
//    public static void main(String[] args)
//    {
//
//        Location location = new Location();
//        location.setVehicleId("1");
//        location.setTimestamp(System.currentTimeMillis() / 1000L);
//        location.setLatitude(51.687402);
//        location.setLongtitude(5.307759);
//        System.out.println("Generated message " + location.toString());
//
//        Schema locationschema = location.getSchema();
//        System.out.println("locationschema " + locationschema.toString());
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);
//
//        byte[] encodedByteArray = outputStream.toByteArray();
//        String encodedString = outputStream.toString();
//
//        System.out.println("encodedString: "+encodedString);
//
//
//    }
//
//}