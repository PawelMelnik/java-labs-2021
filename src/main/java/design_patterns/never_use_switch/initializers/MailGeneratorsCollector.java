package design_patterns.never_use_switch.initializers;

import design_patterns.never_use_switch.mail_strategy.MailGenerator;

import java.util.List;

public interface MailGeneratorsCollector {

    public List<MailGenerator> collectMailGenerators();
}
