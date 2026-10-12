package game;

import java.util.*; 
import java.io.*; 
import java.lang.reflect.Array;
import java.net.*;
import java.util.concurrent.*;




public class Deck{

private final  ArrayList<Card> deck = new ArrayList<Card>();


private void addcards(Card card, int count) {   
    for (int i = 0; i < count; i++) {
        deck.add(card);
    }
}



public void CreateDeck(int numplayers){
           if(numplayers < 2 || numplayers > 5){
                throw new IllegalArgumentException("Number of players must be between 2 and 5.");
            }
            if(numplayers == 5) {
                addcards(Card.Defuse, 1);
            }
            else{
                 addcards(Card.Defuse, 2);
            }

			addcards(Card.Attack, 4);
			addcards(Card.Favor, 4);
			addcards(Card.Nope, 5);
			addcards(Card.Shuffle, 4);
			addcards(Card.Skip, 4);
			addcards(Card.SeeTheFuture, 5);
			addcards(Card.HairyPotatoCat, 4);
			addcards(Card.Cattermelon, 4);
			addcards(Card.RainbowRalphingCat, 4);
			addcards(Card.TacoCat, 4);
			addcards(Card.OverweightBikiniCat, 4);
       
}

public void ShuffleDeck(){
    Collections.shuffle(deck);
    }


public Card DrawCard(){
    if (deck.isEmpty()){
        throw new IllegalArgumentException("no card left in deck");
    }
        Card drawn_card = deck.get(0);
        deck.remove(0);
        return drawn_card;
}




public  ArrayList<Card> GetTopCards(int count){
            ArrayList<Card> topcards = new ArrayList<Card>();
        if(count < 0 || count > deck.size()){
            throw new IllegalArgumentException("requested cards are to many for the deck size");
        }
        for (int i = 0; i < count; i++) {
            topcards.add((deck.get(i)));
        }
        return(topcards);
}

public void InsertCardInDeck(Card card, int position){
        if(position < 0 || position > deck.size()){
            throw new IllegalArgumentException("invalid deck position:"+ position);
        }
        deck.add(position, card);
}

public void RandomCardInsert(Card card){
            int i = (int) (Math.random() * deck.size());
            InsertCardInDeck(card, i);

}


}