import java.io.*;
import java.nio.charset.Charset;

public class FileCopyAppV3 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: FileCopyAppV3 <arquivo_origem> <arquivo_destino>");
            System.exit(1);
        }

        String sourceFileName = args[0];
        String destFileName = args[1];

        try {
            long startTime = System.currentTimeMillis();

            FileInputStream inputFile = new FileInputStream(sourceFileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputFile, Charset.forName("ISO-8859-1"));

            FileOutputStream outputFile = new FileOutputStream(destFileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputFile, Charset.forName("UTF-8"));

            char[] buffer = new char[8192];
            int charsRead;
            while ((charsRead = inputStreamReader.read(buffer)) != -1) {
                outputStreamWriter.write(buffer, 0, charsRead);
            }

            inputStreamReader.close();
            outputStreamWriter.close();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Conversão e cópia bem sucedidas! Tempo total: " + totalTime + " ms");
        } catch (IOException e) {
            System.err.println("Erro durante a conversão e cópia do arquivo: " + e.getMessage());
        }
    }
}
