package my_own_spring;

import my_own_spring.main_initializer.MainInitializer;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

        IRobot iRobot = MainInitializer.getObjectFactory().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
