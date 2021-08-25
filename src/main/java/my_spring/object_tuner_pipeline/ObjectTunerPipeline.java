package my_spring.object_tuner_pipeline;

import java.util.List;

public class ObjectTunerPipeline {

    //TODO: replace by supplier class
    private final List<ObjectTuner> objectTuners= List.of(new InjectRandomIntTuner(), new InjectByTypeTuner());

    public <T> T tuneObject(T objectToTune) {

        //TODO: can be optimized
        for (ObjectTuner objectTuner: objectTuners) {
            objectToTune = objectTuner.tuneObject(objectToTune);
        }

        return objectToTune;
    }
}
