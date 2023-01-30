import java.net.*;
public class Main
{
    public static void main(String args[])
    {
        InetAddress inetAddress = null;
        String getHostName = null;

        try{
            inetAddress = InetAddress.getLocalHost();
            getHostName = InetAddress.getLocalHost().getHostName();
        }
        catch(UnknownHostException e){
            System.out.println("Nie można uzyskać adresu IP dla tego komputera.");
            System.exit(0);
        }
        String ip = inetAddress.getHostAddress();
        System.out.println("Adres IP tego komputera to: " + ip);
        System.out.println("Nazwa tego komputera to: " + getHostName);
    }
}
