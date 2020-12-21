package Session10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int count = 0;
        try (ServerSocket welcomingSocket = new ServerSocket(3128)) {
            System.out.println("Start server\n Wait for a client ***");
            while (count < 320) {
                Socket connectionSocket = welcomingSocket.accept();
                count++;
                pool.execute(new Handler(connectionSocket, count));
            }
            System.out.print("done.\nServer closed ");
            pool.shutdown();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        System.out.println("done.");
    }
}
