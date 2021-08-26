package my_spring;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectionsConfig implements Config {

    private Reflections scanner = new Reflections("my_spring");
    private Map<Class, Class> ifc2ImplClass = new HashMap<>();

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {
        Class<T> implClass = ifc2ImplClass.get(type);

        if (type.isInterface()) {

            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl was found, please update your config");
                }

                implClass = (Class<T>) classes.iterator().next();
                ifc2ImplClass.put(type, implClass);
                return implClass;
            }
        }

        return type;
    }
}
