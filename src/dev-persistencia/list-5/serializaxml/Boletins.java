package serializaxml;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "boletins")
public class Boletins {
    public Boletins() {}
    
    public Boletins(List<Boletim> boletins) {
        this.boletins = boletins;
    }

    @JacksonXmlElementWrapper(localName = "boletins")
    @JacksonXmlProperty(localName = "boletim")
    private List<Boletim> boletins;

    public List<Boletim> getBoletins() {
        return boletins;
    }

    public void setBoletins(List<Boletim> boletins) {
        this.boletins = boletins;
    }

    @Override
    public String toString() {
        return this.boletins.toString();
    }

}
