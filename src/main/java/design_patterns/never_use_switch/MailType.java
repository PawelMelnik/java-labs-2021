package design_patterns.never_use_switch;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MailType {
    kind(1),
    angry(2);

    MailType(int id) {
        this.id = id;
    }

    private final int id;

    public static MailType getById(int id) {
        Map<Integer, MailType> idToType = Stream.of(MailType.values())
                .collect(Collectors.toMap(val -> val.id, Function.identity()));

        //TODO: Here might be null check
        return idToType.get(id);
    }
}
