package lab3.factory_initializer;

import lab3.hero_factory.*;
import lab3.hero_factory.hero_number_receive_strategy.HeroNumberReceiveStrategy;
import lab3.hero_factory.hero_number_receive_strategy.StandardHeroNumberReceiveStrategy;
import lab3.hero_factory.hero_supplier.HeroSupplier;

public class StandardFactoryInitializer implements FactoryInitializer<StandardHeroFactory> {

    @Override
    public HeroFactoryType getType() {
        return HeroFactoryType.StandardHeroFactory;
    }

    @Override
    public StandardHeroFactory initializeFactory(HeroSupplier heroSupplier) {
        HeroNumberReceiveStrategy heroNumberStrategy = new StandardHeroNumberReceiveStrategy();

        return new StandardHeroFactory(heroSupplier.getAllHeroTypes(), heroNumberStrategy);
    }
}
