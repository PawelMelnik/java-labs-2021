package my_spring.object_proxy_creator;

import lombok.SneakyThrows;
import my_spring.Benchmark;
import my_spring.proxy.ProxyFabric;
import my_spring.proxy.ProxyLambda;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("UnnecessaryLocalVariable")
public class BenchmarkProxyCreator implements ObjectProxyCreator {

    @Override
    public <T> T createProxy(T proxiedObject, RealObjectMeta<T> realObjectMeta) {
        Class<?> realObjectType = realObjectMeta.getObjectWithoutProxies().getClass();

        if (isClassOrMethodAnnotatedWithBenchmark(realObjectType)) {
            return createProxyForBenchmark(proxiedObject, realObjectMeta);
        }

        return proxiedObject;
    }

    @SneakyThrows
    private <T> T createProxyForBenchmark(T proxiedObject, RealObjectMeta<T> realObjectMeta) {

        Class<?> realObjectType = realObjectMeta.getObjectWithoutProxies().getClass();
        Class<T> desiredType = realObjectMeta.getDesiredType();

        Set<Method> methodsToBeBenchmarked = getMethodsToBeBenchmarked(realObjectType);

        ProxyLambda proxyLambda = (method, args) -> {
            if (methodsToBeBenchmarked.contains(method)) {
                return invokeWithBenchmark(proxiedObject, method, args);
            }

            return method.invoke(proxiedObject, args);
        };

        return new ProxyFabric().createProxy(realObjectType, proxyLambda, desiredType);
    }

    private boolean isClassOrMethodAnnotatedWithBenchmark(Class<?> type) {
        return isClassAnnotatedWithBenchmark(type) || isBenchmarkNeededForSomeMethods(type);
    }

    private boolean isBenchmarkNeededForSomeMethods(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
    }

    private boolean isClassAnnotatedWithBenchmark(Class<?> type) {
        return type.isAnnotationPresent(Benchmark.class);
    }

    @SneakyThrows
    private Object invokeWithBenchmark(Object object, Method method, Object[] args) {
        System.out.println("********BENCHMARK STARTED FOR METHOD " + method.getName() + " **********");
        long start = System.nanoTime();
        Object retVal = method.invoke(object, args);
        long end = System.nanoTime();
        System.out.println(end - start);

        System.out.println("********BENCHMARK ENDED FOR METHOD " + method.getName() + " **********");

        return retVal;
    }

    private Set<Method> getMethodsToBeBenchmarked(Class<?> type) {
        Set<Method> methods;
        if (isClassAnnotatedWithBenchmark(type)) {
            methods = new HashSet<>(Arrays.asList(type.getMethods()));
        } else if (isBenchmarkNeededForSomeMethods(type)) {
            methods = getMethodsAnnotatedWithBenchmark(type);
        } else {
            methods = Collections.emptySet();
        }

        return methods;
    }

    private Set<Method> getMethodsAnnotatedWithBenchmark(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .filter(method -> method.isAnnotationPresent(Benchmark.class))
                .collect(Collectors.toSet());
    }
}
