package design_patterns.never_use_switch;

import design_patterns.never_use_switch.mail_strategy.MailGenerator;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class MailSender {

    Map<MailType, MailGenerator> mailTypeToMailGenerator;

    public void send(MailInfo mailInfo) {
        //todo refactor this to beautiful code

        MailGenerator mailGenerator = mailTypeToMailGenerator.get(mailInfo.getMailType());
        String s = mailGenerator.generateMail(mailInfo);
        //here can be strategy on how to send mail
        System.out.println(s);
    }
}
