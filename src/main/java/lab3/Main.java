package lab3;

import lab3.hero.Hero;
import lab3.hero_factory.HeroFactory;
import lab3.hero_factory.HeroFactoryType;
import lab3.hero_factory.HeroesBookType;

public class Main {
    public static void main(String[] args) {
        //initialization
        FactoriesStorage factoriesStorage = new FactoriesStorage();
        factoriesStorage.initialize();

        //business logic
        HeroFactory heroFactory = factoriesStorage.get(HeroFactoryType.StandardHeroFactory, HeroesBookType.LordOfRings);

        Hero hero1 = heroFactory.createHero();
        Hero hero2 = heroFactory.createHero();

        GameManager gameManager = new GameManager();
        gameManager.fight(hero1, hero2);
    }
}
