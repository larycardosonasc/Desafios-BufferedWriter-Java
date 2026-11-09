
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Desafio2 {

    public static void main(String[] args) {

        int totalWindows = 0;
        int totalLinux = 0;
        int totalMac = 0;

        try (
            BufferedReader leitor = new BufferedReader(
                new FileReader("hosts.csv"))
        ) {

            String linha = leitor.readLine();

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(",", -1);

                if (dados.length < 3) {
                    continue;
                }

                String so = dados[2].toLowerCase();

                if (so.contains("windows")) {
                    totalWindows++;

                } else if (so.contains("linux") ||
                           so.contains("kali") ||
                           so.contains("ubuntu") ||
                           so.contains("debian") ||
                           so.contains("rocky")) {

                    totalLinux++;

                } else if (so.contains("mac")) {
                    totalMac++;
                }
            }

            System.out.println("CONTAGEM DE SISTEMAS OPERACIONAIS");
            System.out.println("Windows: " + totalWindows);
            System.out.println("Linux: " + totalLinux);
            System.out.println("macOS: " + totalMac);

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
