package my_spring.proxy;

import lombok.SneakyThrows;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Modifier;

public class ProxyFabric {

    private final ProxyCreator dynamicProxyCreator = new DynamicProxyCreator();
    private final ProxyCreator cglibProxyCreator = new CglibProxyCreator();

    @SneakyThrows
    public <T> T createProxy(Class<?> realType, ProxyLambda proxyLambda, Class<T> desiredType) {

        //TODO: replace with strategy pattern
        if (desiredType.isInterface()) {
            return createDynamicProxy(realType, proxyLambda);
        } else if (Modifier.isAbstract(desiredType.getModifiers())) {//TODO: check if CGLIB works for it
            throw new OperationNotSupportedException("Poka ne umeyu abstract class: " + realType.getName());
        } else {
            //TODO: подумать про вариации таких цепочек, что будет, если сначала jdk, потом cglib или такое невозможно???
            return createCGLibProxy(realType, proxyLambda);
        }
    }

    @SneakyThrows
    private <T> T createDynamicProxy(Class<?> proxiedObject, ProxyLambda realType) {

        return dynamicProxyCreator.createProxy(proxiedObject, realType);
    }

    @SneakyThrows
    private <T> T createCGLibProxy(Class<?> realType, ProxyLambda proxyLambda) {
        if (Modifier.isFinal(realType.getModifiers())) {
            throw new OperationNotSupportedException("Poka ne umeyu final class nasledovat: " + realType.getName());
        }

        return cglibProxyCreator.createProxy(realType, proxyLambda);
    }
}
