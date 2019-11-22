package Lab2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import Lab2.model.Actors;
import Lab2.exception.ConvertException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class XmlSerializer<T> implements IO<T> {

    private Class<T> classObject;

    /**
     *
     * @param type
     * constructor which set type of object
     */
    public XmlSerializer(Class<T> type) {
        this.classObject=type;
    }

    /**
     *
     * @param obj
     * @param file
     * Convert object to xml and save into file directly
     */
    @Override
    public void toFile(T obj, File file) throws ConvertException {
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.writeValue(file, obj);
        } catch (IOException e) {
            throw new ConvertException(e.getMessage());
        }
    }

    /**
     *
     * @param file
     * @return java object
     * convert xml into java object
     */
    @Override
    public T fromFile(File file) throws ConvertException {
        try {
            XmlMapper mapper = new XmlMapper();
            return mapper.readValue(file, classObject);

        } catch (IOException e) {
            throw new ConvertException(e.getMessage());
        }
    }

    /**
     *
     * @param obj
     * @return obj as a xmlString
     * @throws JsonProcessingException
     */
    @Override
    public String serializeToString(T obj) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(obj);
    }

    @Override
    public T deserializeFromString(String string) throws IOException {
        XmlMapper mapper= new XmlMapper();
        return mapper.readValue(string, classObject);
    }

//    public static <XmlProcessingException> void main(String[] args) throws JsonProcessingException {
//        XmlSerializer<Actors> xmlSerializer= new XmlSerializer<>(Actors.class);
//        Actors actors;
//
//        ArrayList<Actors> arrayActors = new ArrayList<>();
//        actors = new Actors().new Builder()
//                .setFirstName("FirstName")
//                .setLastName("LastName")
//                .setBirthday(LocalDate.parse("2019-11-21"))
//                .setSalary(4500.0)
//                .build();
//        arrayActors.add(actors);
//        System.out.println( xmlSerializer.serializeToString(actors));
//
//    }
}