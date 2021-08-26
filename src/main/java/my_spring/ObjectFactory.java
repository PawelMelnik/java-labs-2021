package my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import my_spring.object_configurator_supplier.ObjectConfiguratorSupplier;
import my_spring.object_configurator_supplier.ReflectionsConfiguratorSupplier;
import my_spring.object_proxy_creator.ObjectChanger;
import my_spring.object_proxy_creator.RealObjectMeta;
import my_spring.object_proxy_creator_supplier.ReflectionsProxyCreatorSupplier;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static final ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private final Reflections scanner = new Reflections("my_spring");

    private final List<ObjectConfigurator> configurators;
    private final List<ObjectChanger> proxyCreators;

    @SneakyThrows
    public ObjectFactory() {
        ObjectConfiguratorSupplier objectConfiguratorSupplier = new ReflectionsConfiguratorSupplier("my_spring");
        ReflectionsProxyCreatorSupplier proxyCreatorSupplier = new ReflectionsProxyCreatorSupplier("my_spring");

        this.configurators = objectConfiguratorSupplier.collectConfigurators();
        this.proxyCreators = proxyCreatorSupplier.collectSuppliers();
    }

    @SneakyThrows
    public <T> T createObject(Class<T> desiredType) {

        Class<T> implType = resolveImple(desiredType);

        T t = implType.getDeclaredConstructor().newInstance();

        configure(t);

        invokeInit(implType, t);

        final T proxiedObject = createProxies(t, desiredType);

        return proxiedObject;
    }


    private <T> void invokeInit(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> allMethods = ReflectionUtils
                .getAllMethods(type, method -> method.isAnnotationPresent(PostConstruct.class));

        for (Method method : allMethods) {
            method.invoke(t);
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    private <T> T createProxies(final T objectToBeProxied, final Class<T> desiredType) {

        T proxiedObject = objectToBeProxied;
        //TODO: remove desired type somehow
        final RealObjectMeta<T> realObjectMeta = new RealObjectMeta<>(objectToBeProxied, desiredType);

        for (ObjectChanger proxyCreator : proxyCreators) {
            proxiedObject = proxyCreator.changeObject(proxiedObject, realObjectMeta);
        }

        return proxiedObject;
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl was found, please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }


}
