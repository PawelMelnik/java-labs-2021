package lab3.hero_factory.hero_number_receive_strategy;

import lab3.hero_factory.hero_number_receive_strategy.HeroNumberReceiveStrategy;

import java.util.Random;

public class StandardHeroNumberReceiveStrategy implements HeroNumberReceiveStrategy {

    @Override
    public int getNumberOfHeroNotBiggerThan(int maxHeroNumber) {
        return new Random().nextInt(maxHeroNumber);
    }
}
