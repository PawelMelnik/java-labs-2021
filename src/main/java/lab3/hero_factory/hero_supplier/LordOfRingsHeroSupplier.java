package lab3.hero_factory.hero_supplier;

import lab3.hero.*;
import lab3.hero.at_fight.FightType;
import lab3.hero_factory.HeroesBookType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LordOfRingsHeroSupplier implements HeroSupplier {

    @Override
    public HeroesBookType getType() {
        return HeroesBookType.LordOfRings;
    }

    @Override
    public List<HeroGenerationData> getAllHeroTypes() {
        final HeroGenerationData lordOfTheRing =
                HeroGenerationData.builder()
                        .nameGenerator(()->"Lord of the Ring")
                        .hpGenerator(()->5)
                        .powerGenerator(()->3)
                        .fightTypeGenerator(()-> FightType.NORRIS_STYLE)
                        .build();

        final HeroGenerationData smegul =
                HeroGenerationData.builder()
                        .nameGenerator(()->"smegul")
                        .hpGenerator(()->1)
                        .powerGenerator(()->5)
                        .fightTypeGenerator(()->FightType.NORRIS_STYLE)
                        .build();

        final HeroGenerationData king =
                HeroGenerationData.builder()
                        .nameGenerator(()->"king")
                        .hpGenerator(()-> new Random().nextInt(15))
                        .powerGenerator(()-> new Random().nextInt(15))
                        .fightTypeGenerator(()->FightType.KING_STYLE)
                        .build();

        return Arrays.asList(
                lordOfTheRing,
                smegul,
                king
        );
    }
}
