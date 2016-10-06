//package nl.rubix.kafka;
//
//import nl.rubix.avro.Location;
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericDatumReader;
//import org.apache.avro.generic.GenericDatumWriter;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.avro.io.DatumReader;
//import org.apache.avro.io.DatumWriter;
//import org.apache.avro.file.DataFileStream;
//import org.apache.avro.file.DataFileWriter;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ByteArrayInputStream;
//
//
//public class AvroTest3 {
//    public static void main(String[] args) throws IOException
//    {
//        // Schema
//        String schemaDescription = Location.getClassSchema().toString();
//        Schema s = Schema.parse(schemaDescription);
//        System.out.println("Schema parsed: " + s);
//
//        // Encode the data using JSON schema and embed the schema as metadata along with the data.
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(s);
//        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(writer);
//        dataFileWriter.create(s, outputStream);
//
//        // Build AVRO message
//        Location location = new Location();
//        location.setVehicleId(new org.apache.avro.util.Utf8("VHC-001"));
//        location.setTimestamp(System.currentTimeMillis() / 1000L);
//        location.setLatitude(51.687402);
//        location.setLongtitude(5.307759);
//        System.out.println("Generated message " + location.toString());
//
//        dataFileWriter.append(location);
//        dataFileWriter.close();
//        System.out.println("ENCODE location: " + location);
//        System.out.println("ENCODE locationString: " + location.toString());
//        System.out.println("ENCODE outputStream: " + outputStream);
//
//        // Decode
//        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>();
//        System.out.println("DECODE reader: " + reader);
////        string x = reader.
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