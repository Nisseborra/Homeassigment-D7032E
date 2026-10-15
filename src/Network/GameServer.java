package network;

import game.GameEngine;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import players.Player;




public class GameServer {
                private final ArrayList<Player> players = new ArrayList<>();
                private final ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

                private int port;
                private int Humanplayers;
    
    public GameServer(int port, int numPlayers, int numBots){
        int totalplayers = numPlayers + numBots;
        if(totalplayers < 2 || totalplayers > 5){
               throw new IllegalArgumentException("Number of players must be between 2 and 5.");
        }
        if(numBots == totalplayers){
            throw new IllegalArgumentException("Can't only have bots");
        }
        if(numPlayers < 1){
            throw new IllegalArgumentException("Must have at least one player");
        }
        this.Humanplayers = numPlayers;
          this.port = port;

    }


    public void start(){

        try {
             ServerSocket serverSocket = new ServerSocket(port);
                    System.out.println("Gameserver started on:"+ serverSocket.getInetAddress().getHostAddress() +" "+ serverSocket.getLocalPort());

                
                    
                while(players.size() < Humanplayers){
                    Socket ClientSocket = serverSocket.accept();
                    int playerid = players.size();
                    Player player = new Player(playerid);
                    players.add(player);    
                    ClientHandler clientHandler = new ClientHandler(ClientSocket, player);
                    clientHandlers.add(clientHandler);  
                    new Thread(() -> clientHandler.handleClient()).start();
                    System.out.println("Player " + playerid + " connected.");
                    System.out.println("Current number of players: " + players.size() + "/" + Humanplayers);
                }

                System.out.println("All players connected. Starting the game...");
                GameEngine gameEngine = new GameEngine();
                gameEngine.InitGame(players);
                

                // notify all clients that the game has started


        } catch (Exception e) {
            System.out.println("Something wrong happend in when GameServer start on:"+ port);
        }

      
    }


    //notify all players
    // notify 1 player



    //check if the port is avilibe
    //check if player can join
    //send messages 
    // recive messages
    


    public static void main(String[] args) {
		try {
			if (args.length < 3) {
				throw new IllegalArgumentException("Usage: GameServer <port> <humanPlayers> <numBots>");
			}
			GameServer server = new GameServer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			server.start();
		} catch(Exception e) {
            System.out.println("Cant bla bla bla");
		}
	}
  
     
}