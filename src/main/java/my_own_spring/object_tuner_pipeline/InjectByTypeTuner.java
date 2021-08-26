package my_own_spring.object_tuner_pipeline;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import my_own_spring.InjectByType;
import my_own_spring.main_initializer.MainInitializer;

import java.lang.reflect.Field;

@AllArgsConstructor
public class InjectByTypeTuner implements ObjectTuner {

    @Override
    @SneakyThrows
    public <T> T tuneObject(T objectToTune) {
        Class<?> type = objectToTune.getClass();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object fieldObject = MainInitializer.getObjectFactory().createObject(field.getType());
                field.setAccessible(true);
                field.set(objectToTune, fieldObject);
                field.setAccessible(false);
            }
        }

        return objectToTune;
    }
}
