package real_spring;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Aspect
@Component
public class QuoterAspect {

    /*
        @Before("execution(* real_spring..*.say*(..))")
        public void handleSayMethods() {
            System.out.print("Это цитата: ");
        }*/


  /*  @Before("execution(* real_spring..*.say*(..))")
    public void handleSayMethods(JoinPoint jp) {
        Object proxy = jp.getThis();
        System.out.println(proxy.getClass());
        String originalClassName = jp.getTarget().getClass().getSimpleName();
        System.out.print("Это цитата "+originalClassName+" : ");
    }*/

    //todo write an aspect which handle DBException, without breaking original exception handling if exists
    // send a mail with exception message to all addressees located in mails.properties
    //
    @AfterThrowing(pointcut = "execution(* real_spring..*.say*(..))", throwing = "exception")
    public void handleException(Exception exception) {
        System.out.println("exception aspect");

        if (exception instanceof QuoterAspectDbException) {
            return;
        }
        System.out.println("Exception has been thrown: " + exception.toString());

        throw new QuoterAspectDbException(exception);
    }

    private static class QuoterAspectDbException extends RuntimeException{

        public QuoterAspectDbException(Exception exception) {
            super(exception);
        }
    }
}
