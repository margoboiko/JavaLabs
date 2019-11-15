package Lab2.service;

import Lab2.model.Actors;
import Lab2.exception.ConvertException;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextSerializer {
    private final Integer FIELDS_COUNT = 4;
    private final String FIELDS_SEPARATOR = "---";

    private Object[] getActorsFields(Actors actors) {
        return new Object[]{actors.getFirstName(), actors.getLastName(), actors.getBirthday(), actors.getSalary()};
    }

    private String serializeToString(Actors actors) throws ConvertException {
        try {
            Object[] fields = getActorsFields(actors);
            List<String> stringList = Arrays.stream(fields)
                    .map(Object::toString)
                    .collect(Collectors.toList());
            return String.join(FIELDS_SEPARATOR, stringList);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    private Actors deserializeFromString(String string) throws ConvertException {
        try {
            Actors obj= new Actors();
            String[] fields = string.split(FIELDS_SEPARATOR, FIELDS_COUNT);

            return new Actors().new Builder()
                    .setFirstName(fields[0])
                    .setLastName(fields[1])
                    .setBirthday(LocalDate.parse(fields[2]))
                    .setSalary(Double.valueOf(fields[3]))
                    .build();

        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    public void toFile(Actors actors, File file) {
        try(FileWriter writer = new FileWriter(file)) {
            writer.write(serializeToString(actors));
            writer.flush();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public Actors fromFile(File file) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int character;
            StringBuilder sb = new StringBuilder();
            while ((character = br.read()) != -1) {
                char ch = (char) character;
                if (character == '\n') break;
                sb.append(ch);
            }
            return  deserializeFromString(sb.toString());

        } catch (IOException | ConvertException ex) {
            ex.getMessage();
        }
        return null;
    }

}