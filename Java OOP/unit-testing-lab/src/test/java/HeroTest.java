import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void setUp() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        this.hero = new Hero("Tor", mockedWeapon);
    }

    @Test
    public void testIfHeroGetsTargetXPIfManagesToKillIt() {
        int targetXP = 50;
        int heroXPBeforeKill = this.hero.getExperience();

        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(targetXP);

        this.hero.attack(mockedTarget);

        assertEquals(heroXPBeforeKill + targetXP, this.hero.getExperience());
    }

    @Test
    public void testHeroShouldNotGetXpIfTargetIsStillAlive() {
        int heroXPBeforeKill = this.hero.getExperience();

        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(false);

        assertEquals(heroXPBeforeKill, this.hero.getExperience());
    }

}