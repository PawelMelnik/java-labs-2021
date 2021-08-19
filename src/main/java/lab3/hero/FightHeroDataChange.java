package lab3.hero;

import lombok.Getter;

@Getter
public class FightHeroDataChange {
    private final int powerChange;
    private final int hpChange;

    public FightHeroDataChange(FightHeroDataBuilder fightHeroDataBuilder) {
        this.powerChange = fightHeroDataBuilder.powerChange;
        this.hpChange = fightHeroDataBuilder.hpChange;
    }

    public static class FightHeroDataBuilder {
        private int powerChange = 0;
        private int hpChange = 0;

        public FightHeroDataBuilder minusPower(int value) {
            this.powerChange = this.powerChange - value;
            return this;
        }

        public FightHeroDataBuilder plusPower(int value) {
            this.powerChange = this.powerChange + value;
            return this;
        }

        public FightHeroDataBuilder minusHp(int value) {
            this.hpChange = this.hpChange - value;
            return this;
        }

        public FightHeroDataBuilder plusHp(int value) {
            this.hpChange = this.hpChange + value;
            return this;
        }

        public FightHeroDataChange build() {
            return new FightHeroDataChange(this);
        }

        public FightHeroDataChange noDamage() {
            return new FightHeroDataChange(this);
        }
    }

    public static FightHeroDataBuilder builder() {
        return new FightHeroDataBuilder();
    }
}
