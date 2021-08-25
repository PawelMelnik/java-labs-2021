package my_spring.object_tuner_pipeline;

import lombok.SneakyThrows;
import my_spring.InjectByType;
import my_spring.ObjectFactory;

import java.lang.reflect.Field;

public class InjectByTypeTuner implements ObjectTuner {

    @Override
    @SneakyThrows
    public <T> T tuneObject(T objectToTune) {
        Class<?> type = objectToTune.getClass();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object fieldObject = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(objectToTune, fieldObject);
                field.setAccessible(false);
            }
        }

        return objectToTune;
    }
}
