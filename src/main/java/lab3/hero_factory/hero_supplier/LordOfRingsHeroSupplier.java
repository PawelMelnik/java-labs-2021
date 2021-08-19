package lab3.hero_factory.hero_supplier;

import lab3.hero.HeroImpl;
import lab3.hero.FightType;
import lab3.hero.Hero;
import lab3.hero.HeroData;
import lab3.hero_factory.HeroesBookType;

import java.util.Arrays;
import java.util.List;

public class LordOfRingsHeroSupplier implements HeroSupplier {

    @Override
    public HeroesBookType getType() {
        return HeroesBookType.LordOfRings;
    }

    @Override
    public List<Hero> getAllHeroTypes() {
        final Hero lordOfTheRing = new HeroImpl(HeroData.builder()
                .name("Lord of the Ring")
                .hp(5)
                .power(3)
                .fightType(FightType.NORRIS_STYLE)
                .build());

        final Hero smegul = new HeroImpl(HeroData.builder()
                .name("smegul")
                .hp(1)
                .power(5)
                .fightType(FightType.NORRIS_STYLE)
                .build());

//        final Hero king = new HeroImpl(HeroData.builder()
//                .name("king")
//                .hp(1)
//                .power(5)
//                .fightType(FightType.NORRIS_STYLE)
//                .build());

        return Arrays.asList(
                lordOfTheRing,
                smegul
        );
    }
}
