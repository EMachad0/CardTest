package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public void add(Card card) {
        deck.add(card);
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        Card aux = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return aux;
    }

}
