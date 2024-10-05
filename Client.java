import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private BufferedReader userInput;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected to the server");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = userInput.readLine();
                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Server: " + input.readLine());
            }

            closeConnections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() throws IOException {
        input.close();
        output.close();
        userInput.close();
        socket.close();
    }

    public static void main(String[] args) {
        new Client("localhost", 5000);
    }
}
