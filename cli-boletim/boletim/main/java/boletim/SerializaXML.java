package boletim;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SerializaXML {
    public static void serializar() {
        String arquivoCSV = "boletins.csv";
        String arquivoXML = "boletins.xml";

        try {
            List<Boletim> boletins = lerCSV(arquivoCSV);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(new File(arquivoXML), boletins);

            System.out.println("conversao do xml concluida");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("errr ao serializar xml");
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