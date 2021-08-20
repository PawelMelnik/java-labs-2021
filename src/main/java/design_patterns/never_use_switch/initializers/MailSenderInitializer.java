package design_patterns.never_use_switch.initializers;

import design_patterns.never_use_switch.MailSender;
import design_patterns.never_use_switch.MailType;
import design_patterns.never_use_switch.mail_strategy.AngryMailGenerator;
import design_patterns.never_use_switch.mail_strategy.GoodMailGenerator;
import design_patterns.never_use_switch.mail_strategy.MailGenerator;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MailSenderInitializer {

    @Getter
    private MailSender mailSender;

    public void initialize() {
        Map<MailType, MailGenerator> mailTypeToMailGenerator = collectMailTypeToMailGenerator();

        mailSender = new MailSender(mailTypeToMailGenerator);
    }

    private Map<MailType, MailGenerator> collectMailTypeToMailGenerator() {
        List<MailGenerator> mailGenerators = collectMailGenerators();

        return mailGenerators.stream()
                .collect(Collectors.toMap(
                                MailGenerator::getMailType,
                                Function.identity()
                        )
                );
    }

    private List<MailGenerator> collectMailGenerators() {
        //TODO: Here might be reflection
        return List.of(new GoodMailGenerator(),
                new AngryMailGenerator()
        );
    }
}
