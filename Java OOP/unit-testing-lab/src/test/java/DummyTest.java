import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 100;
    private static final int XP = 50;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp(){
        this.dummy = new Dummy(HEALTH, XP);
        this.deadDummy = new Dummy(0, XP);
    }

    @Test
    public void testIfDummyTakesDamageAccordingToAttackersPoints() {
        int attackPoints = 10;
        dummy.takeAttack(attackPoints);

        assertEquals(this.dummy.getHealth(), HEALTH - attackPoints);
    }

    @Test (expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsExceptionWhenAttacked() {
        int attackPoints = 10;
        deadDummy.takeAttack(attackPoints);
    }

    @Test
    public void testIfDummyReturnsProperXP() {
        int dummyXP = this.deadDummy.giveExperience();

        assertEquals(XP, dummyXP);
    }

    @Test (expected = IllegalStateException.class)
    public void testIfAliveDummyThrowsExceptionWhenGivesXP() {
        this.dummy.giveExperience();
    }

}