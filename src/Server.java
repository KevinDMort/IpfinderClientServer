import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    static int port = 1992;
    static DataInputStream in;
    static DataOutputStream out;
    static ServerSocket server;


    static Socket socket;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(5007);
        socket = server.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        while(true)
        {
            String modtaget = in.readUTF();
            System.out.println("URL modtaget: " + modtaget);
            try {
                InetAddress address = InetAddress.getByName(modtaget);
                System.out.print("Host name: " + address.getHostName() + " ");
                System.out.println("IP address: " + address.getHostAddress());
                out.writeUTF(address.getHostAddress());
                out.flush();
            }
            catch (UnknownHostException ex) {
                System.err.println("Unknown host or IP address" + modtaget);
                out.writeUTF("Unknown host or IP address");
            }
        }
    }


}
