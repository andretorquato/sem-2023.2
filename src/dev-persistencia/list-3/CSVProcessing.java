// Crie uma aplicação em Java que recebe via linha de comando: 
// (1) o nome de um arquivo CSV; 
// (2) o delimitador usado para separar os campos do arquivo; 
// (3) uma lista de nomes das colunas do arquivo CSV que serão processados. 
// Considere que o arquivo CSV 
// (1) deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador 
// (2). A aplicação deve exibir a soma e a média das colunas selecionadas em 
// (3), caso tenham dados numéricos. Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. Não usar bibliotecas externas para resolver esta questão (usar Java puro). 
// Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV. Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente grandes, mesmo que não caibam na memória RAM. 
// Dica: usar o método split da classe String para separar os valores das colunas em cada linha do arquivo CSV.import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVProcessing {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java CSVProcessing <arquivo.csv> <delimitador> <colunas>");
            System.exit(1);
        }

        String csvFile = args[0];
        String delimiter = args[1];
        String[] selectedColumns = args[2].split(",");

        Map<String, Double> sumColumns = new HashMap<>();
        Map<String, Integer> countColumns = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);

                if (firstLine) {
                    for (String col : selectedColumns) {
                        sumColumns.put(col, 0.0);
                        countColumns.put(col, 0);
                    }
                    firstLine = false;
                } else {
                    for (int i = 0; i < fields.length; i++) {
                        if (sumColumns.containsKey(selectedColumns[i])) {
                            try {
                                double value = Double.parseDouble(fields[i]);
                                sumColumns.put(selectedColumns[i], sumColumns.get(selectedColumns[i]) + value);
                                countColumns.put(selectedColumns[i], countColumns.get(selectedColumns[i]) + 1);
                            } catch (NumberFormatException e) {
                                // ignore values not numerics
                            }
                        }
                    }
                }
            }

            for (String col : selectedColumns) {
                if (countColumns.get(col) > 0) {
                    double sum = sumColumns.get(col);
                    double average = sum / countColumns.get(col);
                    System.out.println("Coluna >> " + col);
                    System.out.println("Soma: " + sum);
                    System.out.println("Media: " + average);
                } else {
                    System.out.println("Coluna >> " + col);
                    System.out.println("Nao contem valores numericos.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

