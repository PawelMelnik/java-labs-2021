package lab3.hero.at_fight.strategies;

import lab3.hero.HeroData;
import lab3.hero.at_fight.FightHeroDataChange;
import lab3.hero.at_fight.HeroAtFight;

public class NorrisHeroAtFightImpl extends AbstractHeroAtFight {

    public NorrisHeroAtFightImpl(HeroData heroData) {
        super(heroData);
    }

    @Override
    public void kick(HeroAtFight visavi) {
        if (visavi == this) {
            System.out.println("Ne napravliay stvol na sebya, opasna!");
            return;
        }

        FightHeroDataChange fightHeroDataChange = FightHeroDataChange.builder()
                .minusHp(heroData.getPower())
                .build();
        System.out.println("Eto tebe za sashky! Poluchi na " + heroData.getPower());

        visavi.getDamage(fightHeroDataChange);
    }
}
