package nl.rubix.kafka;

import nl.rubix.avro.Location;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;


public class KafkaProducerAvroByte
{
    public static void main(String[] args) throws IOException
    {
        KafkaProducerAvroByte producer = new KafkaProducerAvroByte();
        producer.ProduceKafkaByte();
    }

    public ByteArrayOutputStream GenerateAvroStream() throws IOException
    {
        // Schema
        String schemaDescription = Location.getClassSchema().toString();
        Schema s = Schema.parse(schemaDescription);
        System.out.println("Schema parsed: " + s);

        // Encode the data using JSON schema and embed the schema as metadata along with the data.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(s);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(writer);
        dataFileWriter.create(s, outputStream);

        // Build AVRO message
        Location location = new Location();
        location.setVehicleId(new org.apache.avro.util.Utf8("VHC-001"));
        location.setTimestamp(System.currentTimeMillis() / 1000L);
        location.setLatitude(51.687402);
        location.setLongtitude(5.307759);
        System.out.println("Message location " + location.toString());

        dataFileWriter.append(location);
        dataFileWriter.close();
        System.out.println("Encode outputStream: " + outputStream);

        return outputStream;
    }

    public void ProduceKafkaByte()
    {
        try
        {
            // Get the Apache AVRO message
            ByteArrayOutputStream data = GenerateAvroStream();
            System.out.println("Here comes the data: " + data);

            // Start KAFKA publishing
            Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092");
            props.put("serializer.class", "kafka.serializer.StringEncoder");
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

            KafkaProducer<String, byte[]> messageProducer = new KafkaProducer<String, byte[]>(props);
            ProducerRecord<String, byte[]> producerRecord = null;
            producerRecord = new ProducerRecord<String, byte[]>("test","1",data.toByteArray());
            messageProducer.send(producerRecord);
            messageProducer.close();
        }
        catch(IOException ex)
        {
            System.out.println ("Well this error happened: " + ex.toString());
        }
    }

}