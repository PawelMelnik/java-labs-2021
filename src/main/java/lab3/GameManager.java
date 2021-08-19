package lab3;

import lab3.hero.Hero;
import lab3.hero.at_fight.HeroAtFight;

public class GameManager {

    public void fight(Hero hero1, Hero hero2) {
        HeroAtFight heroAtFight1 = hero1.atFight();
        HeroAtFight heroAtFight2 = hero2.atFight();

        boolean fightContinues = true;
        while (fightContinues) {
            heroAtFight1.kick(heroAtFight2);
            heroAtFight2.kick(heroAtFight1);

            fightContinues = isFightNeedToBeContinued(heroAtFight1, heroAtFight2);
        }
    }

    private boolean isFightNeedToBeContinued(HeroAtFight heroAtFight1, HeroAtFight heroAtFight2) {
        boolean fightNeedToBeContinued = true;
        if (heroAtFight1.isDead()) {
            logHeroDefeated(heroAtFight1);
            fightNeedToBeContinued = false;
        }

        if (heroAtFight2.isDead()) {
            logHeroDefeated(heroAtFight2);
            fightNeedToBeContinued = false;
        }

        return fightNeedToBeContinued;
    }

    private void logHeroDefeated(HeroAtFight heroAtFight) {
        System.out.println("Hero " + heroAtFight.getHeroName() + " defeated. Good luck to him next time!");
    }
}
