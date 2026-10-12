package game;

import java.util.ArrayList;
import java.util.Random;
import Players.Player;

class GameEngine{

        private GameState gamestate;
        private Deck deck;
        private TurnManager turnManager;

        public void InitGame(ArrayList<Player> players){
                gamestate = new GameState(players);
                deck = new Deck();
                turnManager = new TurnManager();
                    for(int i = 0; i < players.size(); i++){
                        players.get(i).addtohand(Card.Defuse);
                    }
                    
                deck.CreateDeck(players.size());
                deck.ShuffleDeck();
                for(int k = 0; k < 6; k++){
                         for(int i = 0; i < players.size(); i++){
                         players.get(i).addtohand(deck.DrawCard());
                    }
                }
                for(int i = 0; i < players.size()-1; i++){
                    deck.RandomCardInsert(Card.ExplodingKitten);
                }
                deck.ShuffleDeck();

                Random r =new Random();
                int startplayer = r.nextInt(players.size());

                turnManager.SetCurrentTurn(startplayer, players);
             }


        public void PlayCard(Player player, Card card){
                    if(!player.hascard(card)){

                            return;
                    }
                   // CardRules(player, card);

                   

        }

        public void drawCard(){
            Player currentplayer =  gamestate.getCurrentPlayer();
            if(!currentplayer.alive){
                 throw new IllegalArgumentException("Not alive, Game ended");
            }
            Card drawncard = deck.DrawCard();
            currentplayer.addtohand(drawncard);

            if(drawncard != Card.ExplodingKitten){
                turnManager.NextTurn(gamestate.getplayers());
                return;
            }
           
             if(currentplayer.hascard(Card.Defuse)){
                gamestate.AddToDiscardPile(currentplayer.RemoveSpecificCard(Card.Defuse));
                Card expoldingkitten = currentplayer.RemoveSpecificCard(Card.ExplodingKitten);
                    // addd interation later

             }
             else{
                 gamestate.GetCurrentPlayer().Eliminate();
                turnManager.NextTurn(gamestate.GetPlayers());
                // send back that either you or  person is dead
        }


        public GameState GetGameState(){
            return gamestate;
        }






                







        }









}