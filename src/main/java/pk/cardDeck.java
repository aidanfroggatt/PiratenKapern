package pk;

import java.util.ArrayList;
import java.util.Collections;

public class cardDeck {
    ArrayList<cards> deck = new ArrayList<cards>();
    public void fillDeck(){
        int twoSwordSeaBattle = 2, threeSwordSeaBattle = 2, fourSwordSeaBattle = 2,monkeyBusiness = 4, nop = 35-twoSwordSeaBattle-threeSwordSeaBattle-fourSwordSeaBattle-monkeyBusiness;
        for (int i=0; i<twoSwordSeaBattle; i++) deck.add(cards.TWOSWORDSEABATTLE);
        for (int i=0; i<threeSwordSeaBattle; i++) deck.add(cards.THREESWORDSEABATTLE);
        for (int i=0; i<fourSwordSeaBattle; i++) deck.add(cards.FOURSWORDSEABATTLE);
        for (int i=0; i<monkeyBusiness; i++) deck.add(cards.MONKEYBUSINESS);
        for (int i=0; i<nop; i++) deck.add(cards.NOP);
    }
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    public cards drawCard(){
        if (deck.size()<=1){
            fillDeck();
            shuffleDeck();
        }
        cards drawn = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return drawn;
    }
}

