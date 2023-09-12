// Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser decriptado e (2) o nome do arquivo resultante da decriptação e (3) a chave de decriptação.
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Decryptor {

    public static void decrypt(String encryptedFile, String decryptedFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        // Converte a chave em bytes
        byte[] keyBytes = key.getBytes();

        // Cria uma chave secreta com base na chave informada
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        // Cria um objeto Cipher para realizar a descriptografia
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream fis = new FileInputStream(encryptedFile);
        FileOutputStream fos = new FileOutputStream(decryptedFile);
        CipherInputStream cis = new CipherInputStream(fis, cipher);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = cis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        cis.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java Decryptor <arquivoEncriptado> <arquivoDecriptado> <chave>");
            return;
        }

        String encryptedFile = args[0];
        String decryptedFile = args[1];
        String key = args[2];

        try {
            decrypt(encryptedFile, decryptedFile, key);
            System.out.println("decriptacao finalizada com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao descriptar: " + e.getMessage());
        }
    }
}
