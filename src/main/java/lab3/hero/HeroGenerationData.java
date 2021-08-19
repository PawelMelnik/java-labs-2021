package lab3.hero;

import lab3.hero.at_fight.FightType;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Builder
@Getter
public class HeroGenerationData {
    //TODO: How to implement design to generate heroes with different data structure?
    private Supplier<String> nameGenerator;
    private Supplier<Integer> hpGenerator;
    private Supplier<Integer> powerGenerator;
    private Supplier<FightType> fightTypeGenerator;

    public Hero generate() {
        return new HeroImpl(HeroData.builder()
                .name(nameGenerator.get())
                .hp(hpGenerator.get())
                .power(powerGenerator.get())
                .fightType(fightTypeGenerator.get())
                .build());
    }
}
