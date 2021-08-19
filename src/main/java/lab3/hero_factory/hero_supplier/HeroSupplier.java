package lab3.hero_factory.hero_supplier;

import lab3.hero.Hero;
import lab3.hero_factory.HeroesBookType;

import java.util.List;

public interface HeroSupplier {

    HeroesBookType getType();

    List<Hero> getAllHeroTypes();
}
