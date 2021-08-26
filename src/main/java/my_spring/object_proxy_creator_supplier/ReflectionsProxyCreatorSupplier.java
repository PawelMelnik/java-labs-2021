package my_spring.object_proxy_creator_supplier;

import lombok.SneakyThrows;
import my_spring.ReflectionsClassScanner;
import my_spring.object_proxy_creator.ObjectProxyCreator;

import java.util.List;

public class ReflectionsProxyCreatorSupplier implements ObjectProxyCreatorSupplier{

    ReflectionsClassScanner reflectionsClassScanner;

    public ReflectionsProxyCreatorSupplier(String pathToScan) {
        this.reflectionsClassScanner = new ReflectionsClassScanner(pathToScan);
    }

    @Override
    @SneakyThrows
    public List<ObjectProxyCreator> collectSuppliers() {
        return reflectionsClassScanner.collectClassesByType(ObjectProxyCreator.class);

    }
}
