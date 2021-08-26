package my_own_spring.object_tuner_pipeline;

import design_patterns.RandomUtil;
import lombok.SneakyThrows;
import my_own_spring.InjectRandomInt;

import java.lang.reflect.Field;

public class InjectRandomIntTuner implements ObjectTuner {

    @Override
    @SneakyThrows
    public <T> T tuneObject(T objectToTune) {
        Class<?> type = objectToTune.getClass();

        Field[] fields = type.getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                int randomInt = RandomUtil.between(min, max);
                field.setAccessible(true);
                field.set(objectToTune, randomInt);
                field.setAccessible(false);
            }
        }

        return objectToTune;
    }
}
