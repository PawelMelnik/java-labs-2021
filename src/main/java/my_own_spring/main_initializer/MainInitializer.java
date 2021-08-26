package my_own_spring.main_initializer;

import my_own_spring.EmptyObjectCreator;
import my_own_spring.ObjectFactory;
import my_own_spring.object_tuner_pipeline.ObjectTunerPipeline;
import my_own_spring.object_tuner_pipeline.ObjectTunerSupplier;
import my_own_spring.object_tuner_pipeline.ScannerObjectTunerSupplier;

//TODO: remove initialize()
public class MainInitializer {

    private static ObjectFactory objectFactory;

    static {
        initialize();
    }

    //TODO: imagine it is executed at the start of application
    private static void initialize() {
        ObjectTunerSupplier objectTunerSupplier = new ScannerObjectTunerSupplier();
        ObjectTunerPipeline objectTunerPipeline = new ObjectTunerPipeline(objectTunerSupplier.getObjectTuners());
        EmptyObjectCreator emptyObjectCreator = new EmptyObjectCreator();

        objectFactory = new ObjectFactory(objectTunerPipeline, emptyObjectCreator);
    }

    public static ObjectFactory getObjectFactory() {
        return objectFactory;
    }
}
