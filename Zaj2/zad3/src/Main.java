import java.net.*;
public class Main
{
    public static void main(String args[])
    {
        InetAddress[] ips;
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            ips = InetAddress.getAllByName(hostName);

            for (InetAddress address : ips) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
