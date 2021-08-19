package lab3.hero;

import lab3.hero.at_fight.FightType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HeroData {
    @NonNull
    private final String name;
    @NonNull
    private Integer power;
    @NonNull
    private Integer hp;
    @NonNull
    private FightType fightType;
/*  @NonNull
    private T specificData;*/

    public HeroData makeCopy() {
        return HeroData.builder()
                .name(name)
                .power(power)
                .hp(hp)
                .fightType(fightType)
                .build();
    }
}
