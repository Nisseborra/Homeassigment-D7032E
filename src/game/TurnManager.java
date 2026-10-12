package game;


import java.util.ArrayList;
import Players.Player;


class TurnManager{
    private int currentPlayer = 0;
    private int turnsReaming = 1;


    public void SetCurrentTurn(int id, ArrayList<Player> players){
        if(players.isEmpty() || id <0|| id >= players.size()){
             throw new IllegalArgumentException("iinvalid player");
        }
        currentPlayer = id;
    }



    public int GetCurrentTurn(){
        return currentPlayer;
    }
     public int GetTurnsRemaining(){
        return turnsReaming;
    }
    



    private boolean NextAlivePlayer(ArrayList<Player> players){
           if(players.isEmpty()){
            return false;
        }
        for(int i = 0; i < players.size(); i++){
            currentPlayer = (currentPlayer+1)%players.size();
            if(players.get(currentPlayer).isAlive()){
                return true; 
            }
        }
        return false;

    }


    public void NextTurn(ArrayList<Player> players){
        if(players.isEmpty()){
            return;
        }
        turnsReaming--;

        if(turnsReaming > 0) {
            return;
        }

        NextAlivePlayer(players);
        turnsReaming = 1;
    }
    
    public void AddTurns(int extraturns){
        if(extraturns > 0){
            turnsReaming += extraturns;
        }
    }

 





} 

// 