package boletim;

import java.util.Scanner;

public class Menu {
    public static void iniciar() {
    // public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        int selectedItem = -1;

        do {
            clearScreen();
            System.out.println("*********************************");
            System.out.println("*           CLI Boletim         *");
            System.out.println("*********************************");
            for (int i = 1; i <= 5; i++) {
                if (i == selectedItem) {
                    System.out.println("* >>");
                } else {
                    System.out.println("*   ");
                }

                switch (i) {
                    case 1:
                        System.out.println("* 1. Inserir novo Boletim no   *");
                        System.out.println("*     arquivo CSV              *");
                        break;
                    case 2:
                        System.out.println("* 2. Mostrar a quantidade de   *");
                        System.out.println("*     entidades existentes no  *");
                        System.out.println("*     arquivo CSV              *");
                        break;
                    case 3:
                        System.out.println("* 3. Converter os dados do     *");
                        System.out.println("*     arquivo CSV              *");
                        break;
                    case 4:
                        System.out.println("* 4. Compactar o arquivo CSV  *");
                        System.out.println("*     e gerar um novo arquivo *");
                        System.out.println("*     ZIP                     *");
                        break;
                    case 5:
                        System.out.println("* 5. Mostrar na tela o hash   *");
                        System.out.println("*     SHA256 do arquivo CSV   *");
                        break;
                }

                if (i == selectedItem) {
                    System.out.println("<<");
                } else {
                    System.out.println("  ");
                }
            }
            System.out.println("* 0. Sair                       *");
            System.out.println("*********************************");
            System.out.print("Escolha uma das opcoes acima: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (escolha >= 1 && escolha <= 5) {
                selectedItem = escolha;
                performMenuAction(escolha);

                System.out.print("Pressione enter para continuar");
                scanner.nextLine(); // Esperar até que uma tecla seja pressionada
            }

        } while (escolha != 0);

        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void performMenuAction(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("Inserir novo Boletim no arquivo CSV");
                InserirDadosCSV.inserir();
                break;
            case 2:
                System.out.println("Mostrar a quantidade de entidades existentes no arquivo CSV");
                LerCSVBoletins.ler();
                break;
            case 3:
                System.out.println("Converter os dados do arquivo CSV");
                int escolhaF3 = -1;
                do {
                    clearScreen();
                    System.out.println("*********************************");
                    System.out.println("*   Conversao de Dados         *");
                    System.out.println("*********************************");
                    for (int i = 1; i <= 2; i++) {
                        if (i == escolhaF3) {
                            System.out.println("* >>");
                        } else {
                            System.out.println("*   ");
                        }
                        switch (i) {
                            case 1:
                                System.out.println("* 1 Gerar JSON              *");
                                break;
                            case 2:
                                System.out.println("* 2 Gerar XML               *");
                                break;
                        }
                        if (i == escolhaF3) {
                            System.out.println("<<");
                        } else {
                            System.out.println("  ");
                        }
                    }
                    System.out.println("* 0. Voltar ao menu principal  *");
                    System.out.println("*********************************");
                    System.out.print("Escolha uma opcao: ");
                    escolhaF3 = new Scanner(System.in).nextInt();
                    if (escolhaF3 == 0) {
                        break;
                    }
                } while (escolhaF3 < 1 || escolhaF3 > 2);
                if (escolhaF3 == 1) {
                    System.out.println("1 - Gerar JSON");
                    SerializaJSON.serializar();
                } else if (escolhaF3 == 2) {
                    System.out.println("2 - Gerar XML");
                    SerializaXML.serializar();
                }
                break;
            case 4:
                System.out.println("4 - Compactar o arquivo CSV e gerar um novo arquivo ZIP");
                CompactarCSVParaZip.compactar();
                break;
            case 5:
                System.out.println("5 - Mostrar na tela o hash SHA256 do arquivo CSV");
                CalcularHashSHA256.calcular();
                break;
            case 0:
                System.out.println("exit.");
                break;
        }
    }
}
