package my_spring.proxy;

import lombok.SneakyThrows;

import java.lang.reflect.Proxy;

public class DynamicProxyCreator implements ProxyCreator {

    @SneakyThrows
    @Override
    public <T> T createProxy(Class<?> realType, ProxyLambda proxyLambda) {

        return (T) Proxy.newProxyInstance(
                realType.getClassLoader(),
                realType.getInterfaces(),
                (doNotUse, method, args) -> proxyLambda.interceptor(method, args)
        );
    }
}
