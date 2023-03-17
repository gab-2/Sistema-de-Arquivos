import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Arquivos {

    public static void main(String[] args) {
        Scanner Leia = new Scanner(System.in);

        String Palavra, NomeArquivo;
        int TentarNovamente = 0, excluir = 0;

        try {

            do {

                System.out.print("Digite o nome do arquivo: ");
                NomeArquivo = Leia.next();

                Path path = Path.of(NomeArquivo + ".txt");

                Files.createFile(path);

                System.out.println("\nDigite uma letra ou palavra para ser gravada no arquivo " + NomeArquivo);
                System.out.print("Palavra ou letra: ");
                Palavra = Leia.next();

                Files.writeString(path, Palavra); 

                String Texto = Files.readString(path); 

                System.out.println("Texto dentro do arquivo: " + Texto);

                System.out.println("\nDeseja excluir o arquivo " + NomeArquivo + "?");
                System.out.print("Digite 1 para sim || 2 para nao: ");
                excluir = Leia.nextInt();

                if (excluir == 1) {

                    Files.delete(path);

                    System.out.println("\nDeseja começar do início?");
                    System.out.print("Digite 1 para sim || 2 para nao: ");
                    TentarNovamente = Leia.nextInt();

                } else if (excluir == 2) {

                    System.out.println("\nDeseja começar do início?");
                    System.out.print("Digite 1 para sim || 2 para nao: ");
                    TentarNovamente = Leia.nextInt();

                } 

            } while (TentarNovamente != 2);

        } catch (IOException e) {

            System.out.println("Erro ao ler o arquivo!");

        }
    }
}