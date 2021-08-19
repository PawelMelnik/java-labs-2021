package lab3;

import lab3.factory_initializer.FactoryInitializer;
import lab3.factory_initializer.StandardFactoryInitializer;
import lab3.hero_factory.*;
import lab3.hero_supplier.HeroSupplier;
import lab3.hero_supplier.LordOfRingsHeroSupplier;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FactoriesStorage {

    Map<HeroFactoryType, FactoryInitializer> factoryTypeToInitializer;
    Map<HeroesBookType, HeroSupplier> heroesBookToHeroSupplier;

    public void initialize() {
        collectFactoryInitializers();
        collectHeroSuppliers();
    }

    public HeroFactory get(HeroFactoryType heroFactoryType, HeroesBookType heroesType) {
        FactoryInitializer factoryInitializer = factoryTypeToInitializer.get(heroFactoryType);
        HeroSupplier heroSupplier = heroesBookToHeroSupplier.get(heroesType);

        return factoryInitializer.initializeFactory(heroSupplier);
    }

    private void collectFactoryInitializers() {
        final List<FactoryInitializer> factoryInitializers = List.of(new StandardFactoryInitializer());

        factoryTypeToInitializer = factoryInitializers.stream()
                .collect(Collectors.toMap(FactoryInitializer::getType, Function.identity()));
    }

    private void collectHeroSuppliers() {
        final List<HeroSupplier> heroSuppliers = List.of(new LordOfRingsHeroSupplier());

        heroesBookToHeroSupplier = heroSuppliers.stream()
                .collect(Collectors.toMap(HeroSupplier::getType, Function.identity()));
    }
}
