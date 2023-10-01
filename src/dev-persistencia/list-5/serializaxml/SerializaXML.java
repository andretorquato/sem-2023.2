package serializaxml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializaXML {
    public static void main(String[] args) throws Exception {
        Boletim b1 = new Boletim(1, "1", "tech");
        Boletim b2 =  new Boletim(2, "2", "tech");
        List<Boletim> lista = new ArrayList<Boletim>();
        lista.add(b1);
        lista.add(b2);
        Boletins b = new Boletins(lista);
        File f = new File("boletins.xml");

        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(f, b);
        System.out.println("Arquivo serializado com sucesso!");
    }
}


