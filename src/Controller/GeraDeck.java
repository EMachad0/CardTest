package Controller;

import Model.Card;
import Model.Deck;
import processing.core.PApplet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GeraDeck {

    private static final int DECK_SIZE = 10;

    private PApplet view;
    private ArrayList<Card> v = new ArrayList<>();

    public GeraDeck(PApplet view) {
        this.view = view;

        Scanner in;
        try {
            in = new Scanner(new File("./Libraries/CardSuggestion"));

            while (in.hasNextLine()) {
                v.add(new Card(view, in.nextInt(), in.nextInt(), in.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Deck gera(int x, int y) {
        Deck deck = new Deck(view, x, y);

        for (int i = 0; i < DECK_SIZE; i++) {
            deck.add(v.get((int) (Math.random() * DECK_SIZE)));
        }

        return deck;
    }
}
