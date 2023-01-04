import java.net.URL;

public class FP2 {
    public static void main(String[] args) throws Exception {
        // Create a URL object from a string representation of a URL
        URL url = new URL(
            "https://www.example.com:8080" +
            "/path/to/resource?key=value#fragment");

        // Get the different components of the URL
        String protocol = url.getProtocol();
        String host = url.getHost();
        int port = url.getPort();
        String path = url.getPath();
        String query = url.getQuery();
        String fragment = url.getRef();

        // Print the URL components
        System.out.println("Protocol: " + protocol);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Path: " + path);
        System.out.println("Query: " + query);
        System.out.println("Fragment: " + fragment);
    }
}
