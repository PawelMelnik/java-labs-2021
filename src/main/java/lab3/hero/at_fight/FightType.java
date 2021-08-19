package lab3.hero.at_fight;

import lab3.hero.HeroData;
import lab3.hero.at_fight.strategies.KingHeroAtFightImpl;
import lab3.hero.at_fight.strategies.NorrisHeroAtFightImpl;
import lombok.Getter;

public enum FightType {
    NORRIS_STYLE(NorrisHeroAtFightImpl::new),
    KING_STYLE(KingHeroAtFightImpl::new),
    ;

    @Getter
    private final HeroAtFightSupplier heroAtFightSupplier;

    FightType(HeroAtFightSupplier heroAtFightSupplier) {
        this.heroAtFightSupplier = heroAtFightSupplier;
    }

    //May be it should be in another service there is few time
    public HeroAtFight getHeroAtFight(HeroData heroData) {
        return heroAtFightSupplier.getHeroAtFight(heroData);
    }
}
