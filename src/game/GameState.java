package game;

import java.util.ArrayList;
import players.Player;


public class GameState{
    private   ArrayList<Player> Players = new ArrayList<>();
    private  ArrayList<Card> discardpile = new ArrayList<>();

    private int currentplayer;
    private boolean gameover;
    private int winner;
    


    public GameState(ArrayList<Player> players){
       
    if(players.size() < 2 || players.size() > 5){
                throw new IllegalArgumentException("Number of players must be between 2 and 5.");
            }
    this.Players = players;
    this.discardpile = new ArrayList<Card>();
    this.currentplayer = 0;
    this.gameover = false;
    this.winner = -1;

  }

    public int GetPlayerSize(){
        return Players.size();
    }
public ArrayList<Player> GetPlayers(){
    return Players;
}

    // add to discard pile
    public void AddToDiscardPile(Card card){
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null.");
        }
        discardpile.add(card);
    }

    // get discard pile
    public ArrayList<Card> GetDiscardPile(){
        return discardpile;
    }

    // get current player
    public Player GetCurrentPlayer(){
        return Players.get(currentplayer);
    }

    // set current player
    public void SetCurrentPlayer(int playerIndex){
        if(playerIndex < 0 || playerIndex >= Players.size()){
            throw new IllegalArgumentException("Invalid player index.");
        }
        this.currentplayer = playerIndex;
    }

    // check if game is over
    public boolean IsGameOver(){
        return gameover;
    }

    // get winner
        public int GetWinner(){
            return  winner;
        }

    // set winner
        public void SetWinner(int player_id){
            if( player_id < 0 || player_id > Players.size()){
                 throw new IllegalArgumentException("Invalid player index.");
            }
    
            winner = player_id;
        }






    // get gameover
        public boolean GetGameOver(){
            return  gameover;
        }

    public void endgame(Player player){
       SetWinner(player.id);
       gameover = true;
    }



    








}
