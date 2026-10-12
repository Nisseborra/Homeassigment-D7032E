package Player;

import java.util.ArrayList;
import game.Card;

public class Player{
    public int playerid;
    public ArrayList<Card> hand;
    public boolean alive;



public void Addplayer(int player_id){
    if(player_id == null){
        throw new IllegalArgumentException("player_id is empty");
    }
    this.playerid = player_id;
    this.hand = new ArrayList<Card>();
    this.alive = true;
}

public void eliminate(){
    alive = false;
}

public ArrayList<Card> get_hand(){
    return hand;
}

public void addtohand(Card card){
    if(card == null || card.isblank()){
        throw new IllegalArgumentException("Card cant be nothing");
    }
    hand.add(card);
}

public boolean hascard(Card card){
    if(card == null || card.isblank()){
        throw new IllegalArgumentException("Card cant be nothing");
    }
    return hand.contains(card);


}

public Card removefromhandpostion(int pos){
        
        if(pos < 0 || pos > hand.size){
             throw new IllegalArgumentException("outside of the hand");
        }
        Card card = hand.get(pos);
        hand.remove(pos);
        return  card;
}

public Card removespecifiCard(Card card){
                Card card = hascard(card)
                return card;
}



}