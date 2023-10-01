package serializaxml;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class DesserializaXML {
    public static void main(String[] args) throws Exception {
        File file = new File("boletins.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Boletins b = xmlMapper.readValue(file, Boletins.class);
        System.out.println(b);
    }

}


