package example.codeclan.com.cards;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.cards.enums.Suit;
import example.codeclan.com.cards.enums.Value;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/06/2017.
 */

public class TestCard
{
    private Card card;

    @Before
    public void before()
    {
        card = new Card(Suit.CLUBS.toString(), Value.ACE.toString(), Value.ACE.getValue());
    }

    @Test
    public void testGetSuit()
    {
       assertEquals("CLUBS", card.getSuit());
    }

    @Test
    public void testGetName()
    {
        assertEquals("ACE", card.getName());
    }

    @Test
    public void testGetValue()
    {
        assertEquals(11, card.getValue());
    }
}
