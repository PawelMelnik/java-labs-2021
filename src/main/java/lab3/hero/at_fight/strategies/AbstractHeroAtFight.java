package lab3.hero.at_fight.strategies;

import lab3.hero.HeroData;
import lab3.hero.at_fight.FightHeroDataChange;
import lab3.hero.at_fight.HeroAtFight;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractHeroAtFight implements HeroAtFight {
    HeroData heroData;

    @Override
    public boolean isDead() {
        return heroData.getHp() <= 0;
    }

    @Override
    public void getDamage(FightHeroDataChange incrementInData) {
        //might be a problem place
        heroData.setHp(heroData.getHp() + incrementInData.getHpChange());
        heroData.setPower(heroData.getPower() + incrementInData.getPowerChange());
    }

    @Override
    public String getHeroName() {
        return heroData.getName();
    }
}
