package lab3.hero;


import lab3.hero.at_fight.HeroAtFight;

public class HeroImpl implements Hero {

    private final HeroData heroData;

    public HeroImpl(HeroData heroData) {
        this.heroData = heroData;
    }

    @Override
    public HeroData getHeroData() {
        return heroData.makeCopy();
    }

    @Override
    public HeroAtFight atFight() {
        return heroData.getFightType()
                .getHeroAtFight(heroData);
    }

    @Override
    public Hero clone() {
        return new HeroImpl(heroData.makeCopy());
    }
}
