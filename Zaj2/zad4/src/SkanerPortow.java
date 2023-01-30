import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkanerPortow {

    private String adresSerwera;
    private int liczbaWatkow;
    private ExecutorService executor;

    public SkanerPortow(String adresSerwera, int liczbaWatkow) {
        this.adresSerwera = adresSerwera;
        this.liczbaWatkow = liczbaWatkow;
        this.executor = Executors.newFixedThreadPool(liczbaWatkow);
    }

    public void skanuj() {
        for (int i = 0; i < 65536; i++) {
            int port = i;
            executor.execute(() -> {
                try {
                    Socket socket = new Socket(adresSerwera, port);
                    System.out.println("Port " + port + " jest otwarty");
                    socket.close();
                } catch (UnknownHostException e) {
                    System.out.println("Nieznany host: " + adresSerwera);
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        SkanerPortow skaner = new SkanerPortow("localhost", 10);
        skaner.skanuj();
    }
}