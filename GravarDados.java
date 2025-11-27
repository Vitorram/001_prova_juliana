import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravarDados implements Runnable {

    private Pessoa pessoa;
    private static final Object lock = new Object();

    public GravarDados(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("dados.txt", true))) {
                bw.write(pessoa.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
