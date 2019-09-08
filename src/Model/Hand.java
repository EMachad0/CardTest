package Model;

import java.util.ArrayList;

public class Hand {
    private final int space = 10;
    private ArrayList<Card> cards = new ArrayList<>();
    private int qtdCard = cards.size();

    public Hand(Deck deck) {
        for(int i = 1; i <= 5; i ++){
            cards.add(deck.drawCard());
        }
    }

    public void drawHand(Deck deck, int player){
        if(player == 1){
            int x = 1366 / 2;
            int y = 268;

            if(qtdCard == 0){
                cards.get(0).draw(x, y);
            }

            int locateRight = x + (Card.WIDTH / 2) + space;
            int locateLeft = x - (Card.WIDTH / 2) - space;

            for (int i = 1; i <= qtdCard; i++){
                if((i % 2) == 0){
                    cards.get(i).draw(locateRight, y);
                    locateRight += (Card.WIDTH / 2) + space;
                }else{
                    cards.get(i).draw(locateLeft , y);
                    locateLeft += (Card.WIDTH / 2) - space;
                }
            }
        }
    }

    public boolean isEmpty(){
        if(qtdCard == 0)
            return true;
        else
            return false;
    }
}
