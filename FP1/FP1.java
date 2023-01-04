import java.net.InetAddress;

public class FP1 {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        System.out.println("Name: " + hostName);
        System.out.println("Address: " + hostAddress);
    }
}