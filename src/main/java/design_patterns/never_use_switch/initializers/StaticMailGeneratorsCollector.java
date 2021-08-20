package design_patterns.never_use_switch.initializers;

import design_patterns.never_use_switch.mail_strategy.AngryMailGenerator;
import design_patterns.never_use_switch.mail_strategy.GoodMailGenerator;
import design_patterns.never_use_switch.mail_strategy.MailGenerator;

import java.util.List;

public class StaticMailGeneratorsCollector implements MailGeneratorsCollector {

    @Override
    public List<MailGenerator> collectMailGenerators() {
        return List.of(
                new GoodMailGenerator(),
                new AngryMailGenerator()
        );
    }
}
