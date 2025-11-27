import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LerDados implements Runnable {

    private Socket socket;

    public LerDados(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            saida.println("Nome: ");
            String nome = entrada.readLine();

            saida.println("Idade: ");
            String idade = entrada.readLine(); // agora String

            saida.println("Endereço: ");
            String endereco = entrada.readLine();

            saida.println("CPF: ");
            String cpf = entrada.readLine();

            saida.println("Altura: ");
            String altura = entrada.readLine(); // agora String

            saida.println("Data de nascimento: ");
            String dataNasc = entrada.readLine();

            Pessoa pessoa = new Pessoa(nome, endereco, cpf, idade, altura, dataNasc);

            Thread grava = new Thread(new GravarDados(pessoa));
            grava.start();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
