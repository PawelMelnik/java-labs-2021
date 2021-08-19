package lab3.hero;

import lab3.hero.at_fight.HeroAtFight;

public interface Hero {

    //Might be segregated
    HeroData getHeroData();

    HeroAtFight atFight();

    Hero clone();
}
