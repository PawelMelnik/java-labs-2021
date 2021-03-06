package my_own_spring;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import my_own_spring.object_tuner_pipeline.ObjectTunerPipeline;


/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public class ObjectFactory {
    private final ObjectTunerPipeline objectTunerPipeline;
    private final EmptyObjectCreator emptyObjectCreator;

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        T createdObject = emptyObjectCreator.createEmptyObject(type);

        T tunedObject = objectTunerPipeline.tuneObject(createdObject);

        return tunedObject;
    }
}
