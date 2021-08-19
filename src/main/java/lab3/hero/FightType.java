package lab3.hero;

import lombok.Getter;

public enum FightType {
    NORRIS_STYLE(StandardHeroAtFightImpl::new),
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
