package boletim;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactarCSVParaZip {
    public static void compactar() {
        String arquivoCSV = "boletins.csv";
        String arquivoZIP = "boletins.zip";

        compactarParaZIP(arquivoCSV, arquivoZIP);

        System.out.println("compactacao concluida");
    }

    public static void compactarParaZIP(String arquivoOrigem, String arquivoDestino) {
        try {
            FileInputStream arquivoParaCompactar = new FileInputStream(arquivoOrigem);
            FileOutputStream arquivoZIP = new FileOutputStream(arquivoDestino);
            ZipOutputStream zipOutputStream = new ZipOutputStream(arquivoZIP);

            ZipEntry entradaZip = new ZipEntry(arquivoOrigem);
            zipOutputStream.putNextEntry(entradaZip);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = arquivoParaCompactar.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }

            arquivoParaCompactar.close();
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao compactar o arquivo.");
        }
    }
}
