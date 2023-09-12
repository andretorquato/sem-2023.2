
// 1. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar todos os arquivos e subpastas em um arquivo compactado com extensão zip.
import java.io.*;
import java.util.zip.*;

public class CompressZip {

	public static void compressToZip(String zipFileName, String folder) throws IOException {
		FileOutputStream fos = new FileOutputStream(zipFileName);
		ZipOutputStream zos = new ZipOutputStream(fos);

		File directory = new File(folder);
		compactarDiretorioParaZip(zos, directory, "");

		zos.close();
		fos.close();
	}

	private static void compactarDiretorioParaZip(ZipOutputStream zos, File directory, String basePath)
			throws IOException {
		File[] files = directory.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				compactarDiretorioParaZip(zos, file, basePath + file.getName() + "/");
			} else {
				FileInputStream fis = new FileInputStream(file);
				String zipPath = basePath + file.getName();
				ZipEntry zipEntry = new ZipEntry(zipPath);
				zos.putNextEntry(zipEntry);

				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, bytesRead);
				}

				fis.close();
				zos.closeEntry();
			}
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Uso: java CompressZip <nomeArquivoZip> <pasta>");
			return;
		}

		String zipFileName = args[0];
		String folder = args[1];

		try {
			compressToZip(zipFileName, folder);
			System.out.println("arquivos comptados com sucesso.");
		} catch (IOException e) {
			System.err.println("Erro ao compactar: " + e.getMessage());
		}
	}
}
