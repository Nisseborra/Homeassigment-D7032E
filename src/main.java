// behövede den här för någon anledning, men vet inte varför
import game.GameEngine;
import Players.Player;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(0));
        players.add(new Player(1));

        GameEngine game = new GameEngine();
        game.initGame(players);

        System.out.println("Game initialized!");
    }
}