package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class InitMethodInvoker {

    public <T> void invokeInit(T t) {
        Optional<Method> initMethod = Arrays.stream(t.getClass().getMethods())
                .filter(method -> method.getName().equals("init"))
                .findFirst();

        initMethod.ifPresent(method -> init(method, t));
    }

    @SneakyThrows
    private void init(Method method, Object object) {
        method.setAccessible(true);
        method.invoke(object);
        method.setAccessible(false);
    }
}
