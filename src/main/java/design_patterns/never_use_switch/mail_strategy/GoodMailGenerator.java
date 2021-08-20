package design_patterns.never_use_switch.mail_strategy;

import design_patterns.never_use_switch.MailInfo;
import design_patterns.never_use_switch.MailType;

public class GoodMailGenerator implements MailGenerator{
    @Override
    public MailType getMailType() {
        return MailType.kind;
    }

    @Override
    public String generateMail(MailInfo mailInfo) {
        return "Hello, my friend! " +
                mailInfo.getContext() +
                "Kind regards," +
                "Mail Sender";
    }
}
