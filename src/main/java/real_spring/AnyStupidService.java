package real_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service

public class AnyStupidService {

    private final OneMoreStupidService oneMoreStupidService;

    @Autowired
    public AnyStupidService(OneMoreStupidService oneMoreStupidService) {
        this.oneMoreStupidService = oneMoreStupidService;
    }

    @EventListener(ContextRefreshedEvent.class)
    protected void sayKaka(){
        System.out.println("asds");

        oneMoreStupidService.sayHiHi();
        throw new RuntimeException("Exception kaka");
    }
}
