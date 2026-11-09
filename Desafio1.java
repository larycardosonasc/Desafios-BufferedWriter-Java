
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Desafio1 {

    public static void main(String[] args) {

        try (
            BufferedReader leitor = new BufferedReader(
                new FileReader("hosts.csv"));

            BufferedWriter escritor = new BufferedWriter(
                new FileWriter("inventario_status.csv"))
        ) {

            String linha = leitor.readLine();

            escritor.write(linha + ",criticidade,status");
            escritor.newLine();

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(",", -1);

                if (dados.length < 3) {
                    continue;
                }

                String host = dados[0];
                String ip = dados[1];
                String so = dados[2];

                String criticidade;
                String status;

                if (so.contains("Kali")) {
                    criticidade = "Alta";

                } else if (so.contains("Ubuntu") ||
                           so.contains("Debian") ||
                           so.contains("Rocky")) {

                    criticidade = "Baixa";

                } else {
                    criticidade = "Media";
                }

                if (so.toLowerCase().contains("windows")) {
                    status = "Online";

                } else {
                    status = "Em Monitoramento";
                }

                escritor.write(host + "," + ip + "," + so +
                        "," + criticidade + "," + status);

                escritor.newLine();
            }

            System.out.println("Relatorio gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
