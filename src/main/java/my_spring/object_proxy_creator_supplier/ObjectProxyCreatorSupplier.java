package my_spring.object_proxy_creator_supplier;

import my_spring.object_proxy_creator.ObjectChanger;

import java.util.List;

public interface ObjectProxyCreatorSupplier {

    List<ObjectChanger> collectSuppliers();

}
