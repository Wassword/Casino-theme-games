package org.example;

import java.util.ArrayList;

public interface DeckActions {
    void playHand(ArrayList<Card> hand);
    void determineWinner();
}
