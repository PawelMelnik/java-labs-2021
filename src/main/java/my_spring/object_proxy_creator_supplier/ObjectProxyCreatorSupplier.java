package my_spring.object_proxy_creator_supplier;

import my_spring.ObjectConfigurator;
import my_spring.object_proxy_creator.ObjectProxyCreator;

import java.util.List;

public interface ObjectProxyCreatorSupplier {

    List<ObjectProxyCreator> collectSuppliers();

}
