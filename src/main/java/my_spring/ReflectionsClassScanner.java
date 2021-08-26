package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectionsClassScanner {

    private final Reflections scanner;

    public ReflectionsClassScanner(String pathToScan) {
        this.scanner = new Reflections(pathToScan);
    }

    @SneakyThrows
    public <T> List<T> collectClassesByType(Class<T> type) {
        List<T> configurators = new ArrayList<>();

        Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
        for (Class<? extends T> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }

        return configurators;
    }
}
