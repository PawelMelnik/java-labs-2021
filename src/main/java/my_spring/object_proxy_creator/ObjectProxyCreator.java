package my_spring.object_proxy_creator;

public interface ObjectProxyCreator {

    //TODO: not good that objects of equal types. May be pass just class?
    <T> T createProxy(T proxiedObject, final RealObjectMeta<T> realObjectMeta);
}
