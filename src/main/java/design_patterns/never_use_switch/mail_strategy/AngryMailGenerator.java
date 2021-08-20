package design_patterns.never_use_switch.mail_strategy;

import design_patterns.never_use_switch.MailInfo;
import design_patterns.never_use_switch.MailType;

public class AngryMailGenerator implements MailGenerator{
    @Override
    public MailType getMailType() {
        return MailType.angry;
    }

    @Override
    public String generateMail(MailInfo mailInfo) {
        return "Ne ponyal! Eto chto takoe: " +
                mailInfo.getContext() +
                "Eshe raz uvizhy, uvoly!";
    }
}
