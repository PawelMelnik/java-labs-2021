package test;

public class Derived extends Base{

    public void der(){
        doCheck();
    }

    @Override
    public void doSMth() {

        System.out.println("Derived");
    }
}
