package my_spring.object_proxy_creator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RealObjectMeta<T> {
    private final T objectWithoutProxies;
    //TODO: We can pass proxy type instead of desired type because we know it is always single
    private final Class<T> desiredType;
}
