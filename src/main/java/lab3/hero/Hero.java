package lab3.hero;

public interface Hero {

    //Might be segregated
    HeroData getHeroData();

    HeroAtFight atFight();

    Hero clone();
}
