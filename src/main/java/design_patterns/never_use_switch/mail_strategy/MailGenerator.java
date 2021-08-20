package design_patterns.never_use_switch.mail_strategy;

import design_patterns.never_use_switch.MailInfo;
import design_patterns.never_use_switch.MailType;

public interface MailGenerator {

    MailType getMailType();

    String generateMail(MailInfo mailInfo);
}
