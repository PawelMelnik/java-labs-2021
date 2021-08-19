package lab3.hero.at_fight.strategies;

import lab3.hero.HeroData;
import lab3.hero.at_fight.FightHeroDataChange;
import lab3.hero.at_fight.HeroAtFight;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class KingHeroAtFightImpl extends AbstractHeroAtFight {

    //TODO: can be extracted to parent in some part
    @Override
    public void kick(HeroAtFight visavi) {
        if (visavi == this) {
            System.out.println("Ne napravliay stvol na sebya, opasna!");
            return;
        }

        int currentAttack = generateAttack();

        FightHeroDataChange fightHeroDataChange = FightHeroDataChange.builder()
                .minusHp(currentAttack)
                .build();

        System.out.println("Narandomil na " + currentAttack);

        visavi.getDamage(fightHeroDataChange);
    }

    private int generateAttack() {
        return new Random().nextInt(heroData.getPower());
    }
}
