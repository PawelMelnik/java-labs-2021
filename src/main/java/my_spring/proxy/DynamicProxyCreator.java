package my_spring.proxy;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Modifier;

public class DynamicProxyCreator implements ProxyCreator{

    @SneakyThrows
    @Override
    public <T> T createProxy(Class<?> realType, ProxyLambda proxyLambda) {

        if (Modifier.isFinal(realType.getModifiers())) {
            throw new OperationNotSupportedException("Poka ne umeyu final class nasledovat: " + realType.getName());
        }

        MethodInterceptor handler =
                (doNotUse, method, args, methodProxy) -> proxyLambda.interceptor(method, args);

        return (T) Enhancer.create(realType, handler);
    }
}
