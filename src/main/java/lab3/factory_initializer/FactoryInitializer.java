package lab3.factory_initializer;

import lab3.hero_factory.HeroFactory;
import lab3.hero_factory.HeroFactoryType;
import lab3.hero_supplier.HeroSupplier;

public interface FactoryInitializer<T extends HeroFactory> {

    HeroFactoryType getType();

    T initializeFactory(HeroSupplier heroSupplier);
}
