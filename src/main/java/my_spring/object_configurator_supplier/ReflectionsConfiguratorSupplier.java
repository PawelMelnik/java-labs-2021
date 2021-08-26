package my_spring.object_configurator_supplier;

import lombok.SneakyThrows;
import my_spring.ObjectConfigurator;
import my_spring.ReflectionsClassScanner;

import java.util.List;

public class ReflectionsConfiguratorSupplier  implements ObjectConfiguratorSupplier{

    ReflectionsClassScanner reflectionsClassScanner;

    public ReflectionsConfiguratorSupplier(String pathToScan) {
        this.reflectionsClassScanner = new ReflectionsClassScanner(pathToScan);
    }

    @Override
    @SneakyThrows
    public List<ObjectConfigurator> collectConfigurators() {
        return reflectionsClassScanner.collectClassesByType(ObjectConfigurator.class);
    }
}
