package my_spring.object_configurator_supplier;

import my_spring.ObjectConfigurator;

import java.util.List;

public interface ObjectConfiguratorSupplier {

    List<ObjectConfigurator> collectConfigurators();
}
