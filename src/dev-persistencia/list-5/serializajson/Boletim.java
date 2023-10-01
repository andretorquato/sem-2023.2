package serializajson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Boletim {
    @JsonProperty("id")
    private int id;
    @JsonProperty("criador_id")
    private String criador_id;
    @JsonProperty("categoria")
    private String categoria;
    
    public Boletim() {}

    public Boletim(int id, String criador_id, String categoria) {
        this.id = id;
        this.criador_id = criador_id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boletim [id=" + id + ", criador_id=" + criador_id + "]" + "categoria" + categoria;
    }

    
}


