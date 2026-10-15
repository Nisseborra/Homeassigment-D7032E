
import java.io.IOException;
import network.GameServer;
import network.NetworkPlayer;

public class main {
   public static void main(String[] args) throws IOException {
        GameServer server = new GameServer(5000, 2,0);
        Thread serverThread = new Thread(server::start);
        serverThread.start();

        NetworkPlayer player = new NetworkPlayer();
         NetworkPlayer player1 = new NetworkPlayer();
        try {
            
             player.connect("127.0.0.1", 5000);
             player1.connect("127.0.0.1", 5000);
            
        } catch (Exception e) {
             System.out.println("coulnt connect");
        }
        

        
    }
}