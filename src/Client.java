import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static int port = 5007;
    static String host = "localhost";
    static DataInputStream in;
    static DataOutputStream out;

    static Socket socket;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        socket = new Socket(host,port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        while(true)
        {
            System.out.println("Skriv en webadresse");

            String webaddresse = input.nextLine();
            out.writeUTF(webaddresse);
            out.flush();

            System.out.printf("IP adressen for %s er %s",webaddresse,in.readUTF());
            System.out.println();
        }
    }


}
