package my_own_spring;

import lombok.SneakyThrows;

public class EmptyObjectCreator {
    private Config config = new ReflectionsConfig();

    @SneakyThrows
    public  <T> T createEmptyObject(Class<T> type) {
        type = config.getImplClass(type);

        return type.getDeclaredConstructor().newInstance();
    }
}
