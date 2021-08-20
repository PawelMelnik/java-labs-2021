package design_patterns.never_use_switch;

import com.github.javafaker.Faker;
import design_patterns.RandomUtil;
import design_patterns.never_use_switch.initializers.MailSenderInitializer;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MailSenderInitializer mailSenderInitializer = new MailSenderInitializer();
        mailSenderInitializer.initialize();

        MailSender mailSender = mailSenderInitializer.getMailSender();
        Faker faker = new Faker();
        while (true) {

            MailType mailType = MailType.getById(RandomUtil.between(1, 2));
            MailInfo mailInfo = MailInfo.builder()
                    .context(faker.chuckNorris().fact())
                    .mailType(mailType)
                    .build();

            mailSender.send(mailInfo);
            Thread.sleep(2000);

        }
    }
}