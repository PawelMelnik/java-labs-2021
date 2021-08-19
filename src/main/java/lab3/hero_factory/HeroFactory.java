package lab3.hero_factory;

import lab3.hero.Hero;

public interface HeroFactory {

    HeroFactoryType getType();

    Hero createHero();
}
