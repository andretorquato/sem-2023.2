import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public static void encrypt(String originalFile, String encryptedFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes = key.getBytes();

        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream fis = new FileInputStream(originalFile);
        FileOutputStream fos = new FileOutputStream(encryptedFile);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            cos.write(buffer, 0, bytesRead);
        }

        fis.close();
        cos.close();
        fos.close();
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java Encryptor <arquivoOriginal> <arquivoEncriptado> <chave>");
            return;
        }

        String originalFile = args[0];
        String encryptedFile = args[1];
        String key = args[2];

        try {
            encrypt(originalFile, encryptedFile, key);
            System.out.println("encriptacao finalizada.");
        } catch (Exception e) {
            System.err.println("erro ao encriptar: " + e.getMessage());
        }
    }
}
