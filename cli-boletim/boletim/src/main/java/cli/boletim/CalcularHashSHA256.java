package boletim;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalcularHashSHA256 {
    public static void calcular() {
        String arquivoCSV = "boletins.csv";

        try {
            String hashSHA256 = calcularHashSHA256(arquivoCSV);
            System.out.println("Hash SHA-256 do arquivo " + arquivoCSV + ": " + hashSHA256);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.err.println("Erro ao calcular o hash SHA-256.");
        }
    }

    public static String calcularHashSHA256(String arquivo) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream inputStream = new FileInputStream(arquivo);
        byte[] bytesBuffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
            digest.update(bytesBuffer, 0, bytesRead);
        }

        inputStream.close();

        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();

        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
