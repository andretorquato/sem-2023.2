package boletim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SerializaJSON {
    public static void serializar() {
        String arquivoCSV = "boletins.csv";
        String arquivoJSON = "boletins.json";

        try {
            List<Boletim> boletins = lerCSV(arquivoCSV);

            // Serializa a lista de Boletins para JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(arquivoJSON), boletins);

            System.out.println("conversao do JSON concluida");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("erro ao serializar JSON.");
        }
    }

    private static List<Boletim> lerCSV(String arquivoCSV) throws IOException {
        List<Boletim> boletins = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;

            // Ignora a primeira linha (cabeçalho)
            br.readLine();

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Usa StringTokenizer para dividir a linha em campos
                StringTokenizer tokenizer = new StringTokenizer(linha, ",");
                List<String> campos = new ArrayList<>();

                // Adiciona cada campo à lista
                while (tokenizer.hasMoreTokens()) {
                    campos.add(tokenizer.nextToken());
                }

                // Cria um objeto Boletim com base nos campos da linha
                Boletim boletim = new Boletim(
                        Integer.parseInt(campos.get(0)),
                        campos.get(1),
                        campos.get(2),
                        campos.get(3)
                );

                boletins.add(boletim);
            }
        }

        return boletins;
    }
}
