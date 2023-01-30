import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String args[]) {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", 6666);
        } catch (UnknownHostException e) {
            System.out.println("Nieznany host: " + e);
        } catch (IOException e) {
            System.out.println("Błąd wejścia-wyjścia: " + e);
        }

        //deklaracje zmiennych strumieniowych
        String line = null;
        BufferedReader brSockInp = null;
        BufferedReader brLocalInp = null;
        DataOutputStream out = null;
        //utworzenie strumieni
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            brSockInp = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            brLocalInp = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            System.out.println("Błąd wejścia-wyjścia: " + e);
        }

        //pętla główna klienta
        while (true) {
            try {
                line = brLocalInp.readLine();
                out.writeBytes(line + '\n');
                line = brSockInp.readLine();
                System.out.println("Otrzymano od serwera: " + line);
            } catch (IOException e) {
                System.out.println("Błąd wejścia-wyjścia: " + e);
            }
        }
    }

}