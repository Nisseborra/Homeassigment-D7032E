package game;


import java.util.ArrayList;
import players.Player;


class TurnManager{
    private int currentPlayer = 0;
    private int turnsRemaining = 1;


    public void SetCurrentTurn(int id, ArrayList<Player> players){
        if(players.isEmpty() || id <0|| id >= players.size()){
             throw new IllegalArgumentException("invalid player");
        }
        currentPlayer = id;
    }



    public int GetCurrentTurn(){
        return currentPlayer;
    }
     public int GetTurnsRemaining(){
        return turnsRemaining;
    }
    



    private boolean NextAlivePlayer(ArrayList<Player> players){
           if(players.isEmpty()){
            return false;
        }
        for(int i = 0; i < players.size(); i++){
            currentPlayer = (currentPlayer+1)%players.size();
            if(players.get(currentPlayer).IsAlive()){
                return true; 
            }
        }
        return false;

    }


    public void NextTurn(ArrayList<Player> players){
        if(players.isEmpty()){
            return;
        }
        turnsRemaining--;

        if(turnsRemaining > 0) {
            return;
        }

        NextAlivePlayer(players);
        turnsRemaining = 1;
    }
    
    public void AddTurns(int extraturns){
        if(extraturns > 0){
            turnsRemaining += extraturns;
        }
    }

 





} 

// 