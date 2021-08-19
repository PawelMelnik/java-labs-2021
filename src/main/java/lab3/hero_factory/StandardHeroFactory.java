package lab3.hero_factory;

import lab3.hero.Hero;
import lab3.hero.HeroGenerationData;
import lab3.hero_factory.hero_number_receive_strategy.HeroNumberReceiveStrategy;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class StandardHeroFactory implements HeroFactory {

    private final List<HeroGenerationData> allHeroTypes;
    private final HeroNumberReceiveStrategy numberReceiveStrategy;

    @Override
    public HeroFactoryType getType() {
        return HeroFactoryType.StandardHeroFactory;
    }

    @Override
    public Hero createHero() {
        int heroNumber = getRandomHeroNumber();
        Hero hero = allHeroTypes.get(heroNumber)
                .generate();

        return hero.clone();
    }

    private int getRandomHeroNumber() {
        int maxHeroNumber = allHeroTypes.size();

        return numberReceiveStrategy.getNumberOfHeroNotBiggerThan(maxHeroNumber);
    }
}
