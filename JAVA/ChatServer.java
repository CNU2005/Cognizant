// Exercise 35: TCP Client-Server Chat (server side)
// Objective: Use Java sockets for TCP communication.
//
// Run this first in one terminal:  java ChatServer
// Then run the client in another:  java ChatClient
// Type messages on either side; type "bye" to end the conversation.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server starting on port " + port + " ...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for a client to connect...");
            try (Socket client = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Client connected: " + client.getInetAddress());

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.print("You (server): ");
                    String reply = console.readLine();
                    out.println(reply);
                    if (reply != null && reply.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            }
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
