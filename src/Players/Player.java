package players;


import game.Card;
import java.util.ArrayList;


public class Player{
    private int id;
    private ArrayList<Card> hand  = new ArrayList<>();;
    private boolean alive = true;



public Player(int player_id){
    if(player_id < 0){
        throw new IllegalArgumentException("player_id cant be negative");
    }
    this.id = player_id;
}

public int GetId(){ return id;}
public void Eliminate(){alive = false;}
public ArrayList<Card> GetHand(){return new ArrayList<>(hand);}
public boolean HasCard(Card card){return hand.contains(card);}
public boolean IsAlive(){return alive;}

public void AddToHand(Card card){
    if(card == null){
        throw new IllegalArgumentException("Card cant be nothing");
    }
    hand.add(card);
}


public Card RemoveFromHandPosition(int pos){
        if(pos < 0 || pos >= hand.size()){
             throw new IllegalArgumentException("outside of the hand");
        }

        return  hand.remove(pos);
}

public Card RemoveSpecificCard(Card card){
               if(!hand.remove(card)){
                    throw new IllegalArgumentException("Card not in hand");
               }
               return card;
}




}