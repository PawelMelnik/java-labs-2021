package my_spring.proxy;

public interface ProxyCreator {
    <T> T createProxy(Class<?> realType, ProxyLambda proxyLambda);
}
