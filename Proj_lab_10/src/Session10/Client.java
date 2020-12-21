package Session10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 3128)) {
            System.out.println("Connected to server");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("- To Server: ");
                String massage = scanner.nextLine();
                if (massage.equals("over")) {
                    break;
                }
                out.write(massage.getBytes());
                int read = in.read(buffer);
                String massageFromServer = new String(buffer, 0, read);
                System.out.println("+ From Server: " + massageFromServer);
            }
            System.out.print("Closing ... ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("done.");
    }
}
