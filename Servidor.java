import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(8080)) {
            System.out.println("Servidor iniciado! Aguardando clientes...");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                Thread t = new Thread(new LerDados(cliente));
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
