package Model;

import processing.core.PApplet;

import java.util.ArrayList;

public class Hand {

    private final PApplet view;

    private Deck deck;
    private ArrayList<Card> cards = new ArrayList<>();
    private int y;

    private static final int HARD_START = 5;
    private boolean init = true;

    public Hand(PApplet view, Deck deck, int bot) {
        this.deck = deck;
        this.y = bot * (view.height-10-Card.HEIGHT);
        this.view = view;
    }

    public void drawFromDeck() {
        Card card = deck.drawCard();
        card.setVisibility(true);
        cards.add(card);
    }

    public void draw() {
        if (init) init();

        final int space = 10;

        int x = (view.width - cards.size() * (Card.WIDTH + space) - space) / 2;

        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).move(x + i * (Card.WIDTH + space), y, (init) ? 10 : 5);
            cards.get(i).draw();
        }
    }

    private void init() {
        if (cards.size() < HARD_START) {
            if (view.frameCount % 30 == 0) {
                drawFromDeck();
            }
        } else init = false;
    }
}
