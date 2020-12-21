package Session10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


class Handler implements Runnable {

    private Socket connectionSocket;
    private int clientNum;

    /**
     * Create a Handler.
     * @param connectionSocket connection socket
     * @param clientNum        client number
     */
    public Handler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum = clientNum;
    }

    /**
     * An override method for handle multi threading.
     */
    @Override
    public void run() {
        try {
            System.out.println("Client" + clientNum + " connected.");
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];
            StringBuilder output = new StringBuilder();
            do {
                try {
                    int read = in.read(buffer);
                    System.out.println("- From client" + clientNum + ": " + new String(buffer, 0, read));
                    output.append(" ").append(new String(buffer, 0, read));
                    System.out.println("+ To client" + clientNum + ": " + output);
                    out.write(output.toString().getBytes());
                } catch (Exception exception) {
                    break;
                }
            }
            while (true);
            System.out.print("Closing connection for Client" + clientNum + ".\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}