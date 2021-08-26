package my_spring.object_proxy_creator;

public interface ObjectChanger {

    <T> T changeObject(T objectToChange, final RealObjectMeta<T> realObjectMeta);
}
