package lab3.hero;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardHeroAtFightImpl implements HeroAtFight {
    HeroData heroData;

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
