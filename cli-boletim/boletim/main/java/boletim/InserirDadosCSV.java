package boletim;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InserirDadosCSV {
    public static void inserir () {
        Scanner scanner = new Scanner(System.in);

				System.out.println("Informe o ID do boletim informativo:");
				int idBoletim = scanner.nextInt();
				scanner.nextLine();
        System.out.println("Informe o nome do boletim informativo:");
        String nomeBoletim = scanner.nextLine();
        System.out.println("Informe a frequencia de atualizacao (semanalmente, diariamente, intervalo de tempo):");
        String frequenciaAtualizacao = scanner.nextLine();
        System.out.println("Informe a categoria do boletim informativo:");
        String categoria = scanner.nextLine();

        Boletim boletim = new Boletim(idBoletim, nomeBoletim, frequenciaAtualizacao, categoria);

        System.out.println("Informe o titulo do post:");
        String tituloPost = scanner.nextLine();
        System.out.println("Informe o conteudo do post (em markdown):");
        String conteudoPost = scanner.nextLine();

        Post post = new Post(1, tituloPost, boletim.getId(), conteudoPost);

        boletim.adicionarPost(post);

          // Preparar os dados para escrita no CSV
					List<String> linhasCSV = new ArrayList<>();
					String linha = String.format("%d,%s,%s,%s,%d,%s,%s",
									boletim.getId(), boletim.getNome(), boletim.getFrequenciaAtualizacao(),
									boletim.getCategoria(), post.getId(), post.getTitulo(), post.getConteudo());
					
					// Verificar se o arquivo já existe
					String nomeArquivo = "boletins.csv";
					Path arquivoCSV = Path.of(nomeArquivo);
	
					if (!Files.exists(arquivoCSV)) {
							// Se o arquivo não existe, adicione o cabeçalho
							linhasCSV.add("id_boletim,nome,frequencia,categoria,id_post,titulo,conteudo");
					}
					
					linhasCSV.add(linha);
	
					// Escrever no arquivo CSV
					try (FileWriter fileWriter = new FileWriter(nomeArquivo, true)) {
							for (String linhaCSV : linhasCSV) {
									fileWriter.write(linhaCSV + "\n");
							}
							System.out.println("Dados inseridos com sucesso no arquivo CSV!");
					} catch (IOException e) {
							e.printStackTrace();
							System.err.println("Erro ao inserir dados no arquivo CSV.");
					}

        // scanner.close();
    }
}
