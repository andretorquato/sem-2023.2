package boletim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LerCSVBoletins {
    public static void ler() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("boletins.csv"));
            String linha;
            int totalEntidades = 0;

            // Ler e contar as linhas do arquivo CSV
            while ((linha = reader.readLine()) != null) {
                totalEntidades++;
            }

            reader.close();

            System.out.println("Quantidade total de entidades no arquivo CSV: " + (totalEntidades - 1)); // Subtrai 1 para excluir o cabeçalho

            Scanner scanner = new Scanner(System.in);
            int pagina = 1;
            int pageSize = 2;
            int opcao;

            do {
                clearScreen();
                System.out.println("*********************************");
                System.out.println("*        Lista de Boletins      *");
                System.out.println("*********************************");

                // Lê o arquivo CSV novamente para exibir os dados
                reader = new BufferedReader(new FileReader("boletins.csv"));
                linha = reader.readLine(); // Lê e descarta o cabeçalho
                int contador = 0;

                // Avança até a página desejada
                while (contador < (pagina - 1) * pageSize) {
                    linha = reader.readLine();
                    contador++;
                }

                // Exibe os dados da página atual
                for (int i = 0; i < pageSize; i++) {
                    linha = reader.readLine();
                    if (linha == null) {
                        break;
                    }
                    String[] partes = linha.split(",");
                    System.out.println("ID: " + partes[0]);
                    System.out.println("Nome: " + partes[1]);
                    System.out.println("Frequencia: " + partes[2]);
                    System.out.println("Categoria: " + partes[3]);
                    System.out.println("ID do Post: " + partes[4]);
                    System.out.println("Titulo do Post: " + partes[5]);
                    System.out.println("Conteudo do Post: " + partes[6]);
                    System.out.println("*********************************");
                    contador++;
                }

                System.out.println("pagina " + pagina);
                System.out.println("opcoes:");
                System.out.println("1. avancar");
                System.out.println("2. voltar");
                System.out.println("0. sair");
                System.out.print("escolha uma opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (opcao == 1) {
                    pagina++;
                } else if (opcao == 2 && pagina > 1) {
                    pagina--;
                }

                reader.close();

            } while (opcao != 0);

            // scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler o arquivo CSV.");
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
