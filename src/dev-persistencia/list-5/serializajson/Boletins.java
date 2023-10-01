package serializajson;

import java.util.List;

public class Boletins {
    public Boletins() {}
    
    public Boletins(List<Boletim> boletins) {
        this.boletins = boletins;
    }

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
