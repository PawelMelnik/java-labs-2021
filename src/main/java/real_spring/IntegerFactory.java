package real_spring;


import design_patterns.RandomUtil;

/**
 * @author Evgeny Borisov
 */
public class IntegerFactory  {
    public Integer randomInt() throws Exception {
        return RandomUtil.between(100,1200);
    }


}
