import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8080)) {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 6; i++) {
                String pergunta = entrada.readLine();
                System.out.print(pergunta + " ");
                String resposta = sc.nextLine();
                saida.println(resposta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
