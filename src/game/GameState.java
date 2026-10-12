package game;



import java.util.*; 
import java.io.*; 
import java.lang.reflect.Array;
import java.net.*;
import java.util.concurrent.*;

import Player.player;

class GameState{
    private final  ArrayList<Player> Players = new ArrayList<>();
    private final ArrayList<Card> discardpile = new ArrayList<>();

    private int currentplayer;
    private boolean gameover;
    private int winner;
    


    public GameState(arrayList<Player> players){
       
    if(players.size() < 2 || players.size() > 5){
                throw new IllegalArgumentException("Number of players must be between 2 and 5.");
            }
    this.Players = players;
    this.discardpile = new ArrayList<>();
    this.currentplayer = 0;
    this.gameover = false;
    this.winner = null;

  }

    // add to discard pile
    public void add_to_discardpile(Deck.deck card){
        if card == null {
            throw new IllegalArgumentException("Card cannot be null.");
        }
        discardpile.add(card);
    }

    // get discard pile
    public ArrayList<Deck.deck> getDiscardPile(){
        return discardpile;
    }

    // get current player
    public Player getCurrentPlayer(){
        return Players.get(currentplayer);
    }

    // set current player
    public void setCurrentPlayer(int playerIndex){
        if(playerIndex < 0 || playerIndex >= Players.size()){
            throw new IllegalArgumentException("Invalid player index.");
        }
        this.currentplayer = playerIndex;
    }

    // check if game is over
    public boolean isGameOver(){
        return gameover;
    }

    // get winner
        public int get_winner(){
            return  winner;
        }

    // set winner
        public void set_winner(int player_id){
            if( player_id < 0 || player_id > Players.size){
                 throw new IllegalArgumentException("Invalid player index.");
            }
    
            winner = player_id;
        }



    // get players


    // get gameover
        public boolean get_gameover(){
            return  gameover;
        }

    public void endgame(Player player){
       set_winner(player.id);
       gameover = true;
    }



    








}
