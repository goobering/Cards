package example.codeclan.com.cards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import example.codeclan.com.cards.enums.Suit;
import example.codeclan.com.cards.enums.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 22/06/2017.
 */

public class TestDeck
{
    private Deck deck;
    private Card card;

    @Before
    public void before()
    {
        deck = new Deck();
        card = new Card(Suit.CLUBS.toString(), Value.ACE.toString(), Value.ACE.getValue());
    }

    @Test
    public void testDrawRandomCard()
    {
        deck.makeDeck();

        int startCount = deck.numCards();
        deck.drawFirstCard();
        assertEquals(startCount - 1, deck.numCards());
    }

    @Test
    public void testMakeDeck()
    {
        // Check that makeDeck populates with 52 cards
        deck.makeDeck();
        assertEquals(52, deck.numCards());

        //Test cards are random

        //No 'all cards' property for deck - need to iterate through drawRandomCard
        ArrayList<Card> testCardList = new ArrayList<Card>();

        for(int i = 0; i < deck.numCards(); i++)
        {
            testCardList.add(deck.drawFirstCard());
        }

        // Set contents are always distinct
        Set<Card> set = new HashSet<Card>(testCardList);

        assertEquals(false, set.size() < testCardList.size());
    }
}
