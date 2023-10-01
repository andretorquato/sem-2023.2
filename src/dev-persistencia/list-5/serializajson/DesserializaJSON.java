package serializajson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DesserializaJSON {
    public static void main(String[] args) throws Exception {
        File file = new File("boletins.json");
        ObjectMapper objMapper = new ObjectMapper();
        Boletins b = objMapper.readValue(file, Boletins.class);
        System.out.println(b);
    }

}


