package my_own_spring.object_tuner_pipeline;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ScannerObjectTunerSupplier implements ObjectTunerSupplier {
    private final Reflections scanner = new Reflections("my_spring.object_tuner_pipeline");

    @Override
    @SneakyThrows
    public List<ObjectTuner> getObjectTuners() {
        Set<Class<? extends ObjectTuner>> mailGeneratorSubtypes =
                scanner.getSubTypesOf(ObjectTuner.class);

        List<ObjectTuner> objectTuners = new ArrayList<>();
        for (Class<? extends ObjectTuner> mailGeneratorClass : mailGeneratorSubtypes) {
            ObjectTuner objectTuner = mailGeneratorClass.getDeclaredConstructor()
                    .newInstance();
            objectTuners.add(objectTuner);
        }

        return objectTuners;
    }
}
