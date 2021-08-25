package my_spring.object_tuner_pipeline;

import lombok.SneakyThrows;

public interface ObjectTuner {

    @SneakyThrows
    <T> T tuneObject(T obj);
}
