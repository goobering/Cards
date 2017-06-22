package example.codeclan.com.cards;

import org.junit.Before;
import org.junit.Test;

import example.codeclan.com.cards.enums.Suit;
import example.codeclan.com.cards.enums.Value;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/06/2017.
 */

public class TestPlayer
{
    Player player;

    @Before
    public void before()
    {
        player = new Player("Steve");
    }

    @Test
    public void testGetName()
    {
        assertEquals("Steve", player.getName());
    }

    @Test
    public void testGetSetCard()
    {
        Card card = new Card(Suit.CLUBS.toString(), Value.ACE.toString(), Value.ACE.getValue());
        player.addCard(card);
        assertEquals(card, player.getCards().get(0));
    }

}
