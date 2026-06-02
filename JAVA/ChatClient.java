// Exercise 35: TCP Client-Server Chat (client side)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server at " + host + ":" + port);

            String userInput;
            while (true) {
                System.out.print("You (client): ");
                userInput = console.readLine();
                if (userInput == null) {
                    break;
                }
                out.println(userInput);
                if (userInput.equalsIgnoreCase("bye")) {
                    break;
                }

                String serverReply = in.readLine();
                if (serverReply == null || serverReply.equalsIgnoreCase("bye")) {
                    System.out.println("Server ended the conversation.");
                    break;
                }
                System.out.println("Server: " + serverReply);
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
