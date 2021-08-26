package my_spring.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@FunctionalInterface
public interface ProxyLambda {

    Object interceptor(Method method, Object... args) throws InvocationTargetException, IllegalAccessException;
}
