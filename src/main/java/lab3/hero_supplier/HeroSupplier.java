package lab3.hero_supplier;

import lab3.hero.HeroGenerationData;
import lab3.hero_factory.HeroesBookType;

import java.util.List;

public interface HeroSupplier {

    HeroesBookType getType();

    List<HeroGenerationData> getAllHeroTypes();
}
