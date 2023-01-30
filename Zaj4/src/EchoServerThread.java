import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class EchoServerThread implements Runnable
{
    protected Socket socket;
    public EchoServerThread(Socket clientSocket)
    {
        this.socket = clientSocket;
    }
    public void run()
    {
//deklaracje zmiennych
        BufferedReader brinp = null;
        DataOutputStream out = null;
        String threadName = Thread.currentThread().getName();
        try{
//inicjalizacja strumieni
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            //pętla główna
            String line = null;
            while((line = brinp.readLine()) != null){
                System.out.println("["+threadName+"] Otrzymano: "+line);
                //odesłanie danych do klienta
                out.writeBytes(line + "\n");
            }
        }
        catch(IOException e){
            System.out.println("Błąd wejścia-wyjścia: " + e);
        }
        finally{
            try{
                socket.close();
            }
            catch(IOException e){
                System.out.println("Błąd przy zamykaniu gniazda: " + e);
            }
        }
    }

}


