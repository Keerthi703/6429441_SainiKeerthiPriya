import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected!");
                
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Client: " + line);
                    System.out.print("You: ");
                    out.println(keyboard.readLine());
                }
            }
        }
    }
}
