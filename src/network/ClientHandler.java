package network;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import players.Player;


public class ClientHandler {
    private Socket clientSocket;
    private Player player;

    public ClientHandler(Socket clientSocket, Player player) {
        this.clientSocket = clientSocket;
        this.player = player;
    }

    public void handleClient() {
        try(
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
        {
            out.println("Welcome to exploding kittend");
             String message;
                while((message = in.readLine()) != null){       
                    if(message.equals("Quit"));
                    
                        

                }




        } catch(Exception e)  {
        }
        // Implement the logic to handle the client connection here
        // For example, you can read from and write to the clientSocket
    }
    public Player getPlayer() {
        return player;
    }
    public Socket getClientSocket() {
        return clientSocket;
    }
    


}