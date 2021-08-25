package my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import my_spring.object_tuner_pipeline.ObjectTunerPipeline;


/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    //TODO: tuners will be injected
    private static final ObjectTunerPipeline objectTunerPipeline = new ObjectTunerPipeline();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        T createdObject = createEmptyObject(type);

        T tunedObject = (T)objectTunerPipeline.tuneObject(createdObject);

        return tunedObject;
    }

    @SneakyThrows
    private <T> T createEmptyObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        return type.getDeclaredConstructor().newInstance();
    }
}
