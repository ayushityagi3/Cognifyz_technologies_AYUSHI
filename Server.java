import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started, waiting for a client...");

            socket = serverSocket.accept();
            System.out.println("Client connected");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                message = input.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Client: " + message);
                output.println("Message received: " + message);
            }

            closeConnections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() throws IOException {
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        new Server(5000);
    }
}
