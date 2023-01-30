import java.net.*;
import java.io.*;
import java.util.Random;

public class Main
{
    public static void main(String args[])
    {
        Socket socket = null;
        String[] pages = {"www.wp.pl", "www.ug.edu.pl", "www.onet.pl", "www.interia.pl", "www.helion.pl"};

        Random rand = new Random();
        int num = rand.nextInt(pages.length);

        try{
            socket = new Socket(pages[num], 80);
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
        if(socket != null){
            System.out.println(socket);
        }
    }
}
