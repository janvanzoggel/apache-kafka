//package nl.rubix.kafka;
//
//import nl.rubix.avro.Location;
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericData;
//import org.apache.avro.generic.GenericDatumReader;
//import org.apache.avro.generic.GenericDatumWriter;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.avro.io.*;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
//public class AvroTest2 {
//    public static void main(String[] args) throws IOException
//    {
//        // Schema
//        String schemaDescription = Location.getClassSchema().toString();
//        Schema s = Schema.parse(schemaDescription);
//        System.out.println("Schema parsed: " + s);
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);
//        System.out.println("Encoder: " + e);
//        GenericDatumWriter w = new GenericDatumWriter(s);
//        System.out.println("DatumWriter: " + w);
//
//        // Build AVRO message
//        Location location = new Location();
//        location.setVehicleId(new org.apache.avro.util.Utf8("VHC-001"));
//        location.setTimestamp(System.currentTimeMillis() / 1000L);
//        location.setLatitude(51.687402);
//        location.setLongtitude(5.307759);
//        System.out.println("Generated message " + location.toString());
//
//        // Encode and flush the character stream
//        // Flushes the output stream and forces any buffered output bytes to be written out.
//        // The general contract of flush is that calling it is an indication that, if any bytes previously
//        // written have been buffered by the implementation of the output stream, such bytes should
//        // immediately be written to their intended destination.
//        w.write(location, e);
//        e.flush();
//
//        //
//        byte[] encodedByteArray = outputStream.toByteArray();
//        String encodedString = outputStream.toString();
//        System.out.println("encodedString: " +encodedString);
//
//        // Decode using same schema
//        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(s);
//        Decoder decoder = DecoderFactory.get().binaryDecoder(encodedByteArray, null);
//        GenericRecord result = reader.read(null, decoder);
//        System.out.println(result.get("vehicle_id").toString());
//        System.out.println(result.get("timestamp").toString());
//        System.out.println(result.get("latitude").toString());
//        System.out.println(result.get("longtitude").toString());
//
//
//
//    }
//}