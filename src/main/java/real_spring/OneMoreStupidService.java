package real_spring;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class OneMoreStupidService {
    @EventListener(ContextRefreshedEvent.class)
    protected void sayHiHi(){
        System.out.println("wewe");
        throw new RuntimeException("Exception hihi");
    }
}
