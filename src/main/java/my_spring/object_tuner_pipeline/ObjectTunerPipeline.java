package my_spring.object_tuner_pipeline;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ObjectTunerPipeline {

    private final List<ObjectTuner> objectTuners;

    public <T> T tuneObject(T objectToTune) {

        //TODO: can be optimized
        for (ObjectTuner objectTuner: objectTuners) {
            objectToTune = objectTuner.tuneObject(objectToTune);
        }

        return objectToTune;
    }
}
