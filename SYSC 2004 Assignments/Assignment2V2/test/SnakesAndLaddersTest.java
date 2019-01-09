import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Schramm
 */
public class SnakesAndLaddersTest {
    
    public SnakesAndLaddersTest() {
    }

    @Test
    public void test1ArgConstructor() {
        SnakesAndLadders instance = new SnakesAndLadders(1);
        assertEquals(1, instance.getPlayerPosition(0));
        try {
            assertEquals(1,instance.getPlayerPosition(1));
            fail();
        } catch (ArrayIndexOutOfBoundsException e) { };
        assertEquals("0:1 ", instance.toStringCurrentPositions());

    }
    @Test
    public void testDefaultConstructor() {

        SnakesAndLadders instance = new SnakesAndLadders();
        assertEquals(1, instance.getPlayerPosition(0));
        assertEquals(1, instance.getPlayerPosition(1));
        try {
            assertEquals(1,instance.getPlayerPosition(2));
            fail();
        } catch (ArrayIndexOutOfBoundsException e) { };
        assertEquals("0:1 1:1 ", instance.toStringCurrentPositions());

    }
    /**
     * Test of takeTurn method, of class SnakesAndLadders.
     */
    @Test
    public void testTakeTurn() {
        SnakesAndLadders instance = new SnakesAndLadders();
        boolean doubleRoll = instance.takeTurn(1);
        int position = instance.getPlayerPosition(1);
        assertNotEquals(1, position);
        position = instance.getPlayerPosition(0);
        assertEquals(1, position);
    }

    /**
     * Test of isPlayerWinner method, of class SnakesAndLadders.
     */
    @Test
    public void testIsPlayerWinner() {
        SnakesAndLadders instance = new SnakesAndLadders();
        assertEquals(false, instance.isPlayerWinner(0));
    }

    /**
     * Test of getWinner method, of class SnakesAndLadders.
     */
    @Test
    public void testGetWinner() {
        SnakesAndLadders instance = new SnakesAndLadders();
        assertEquals(-1, instance.getWinner());
    }

    /**
     * Test of toString method, of class SnakesAndLadders.
     */
    @Test
    public void testToString() {
      // TBD
    }

    
}
