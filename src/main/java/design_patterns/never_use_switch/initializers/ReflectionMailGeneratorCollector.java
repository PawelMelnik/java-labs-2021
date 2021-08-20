package design_patterns.never_use_switch.initializers;

import design_patterns.never_use_switch.mail_strategy.MailGenerator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectionMailGeneratorCollector implements MailGeneratorsCollector {

    private static final String MAIL_GEN_PATH = "design_patterns.never_use_switch";

    @Override
    @SneakyThrows
    public List<MailGenerator> collectMailGenerators() {
        Reflections reflections = new Reflections(MAIL_GEN_PATH);

        Set<Class<? extends MailGenerator>> mailGeneratorSubtypes =
                reflections.getSubTypesOf(MailGenerator.class);

/*            mailGeneratorSubtypes.stream()
                    .map(mailGenerator -> mailGenerator.getDeclaredConstructor())
                    .map(generatorConstructor -> generatorConstructor.newInstance())
                    .map(gen -> (MailGenerator)gen)
                    .collect(Collectors.toList());*/

        List<MailGenerator> mailGenerators = new ArrayList<>();
        for (Class<? extends MailGenerator> mailGeneratorClass : mailGeneratorSubtypes) {
            MailGenerator mailGenerator = mailGeneratorClass.getDeclaredConstructor()
                    .newInstance();
            mailGenerators.add(mailGenerator);
        }

        return mailGenerators;
    }
}
