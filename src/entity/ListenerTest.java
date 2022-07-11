package entity;

public class ListenerTest {

    private Listeners listeners;

    public void setListeners(Listeners listeners) {
        this.listeners = listeners;
    }

    public void monitored(){
        System.out.println("这个方法被监听，所以执行完这句话之后执行监听方法");
        listeners.listenAndDo();
    }

    public static void main(String[] args) {
        ListenerTest listenerTest = new ListenerTest();
        listenerTest.setListeners(new Listeners() {
            @Override
            public void listenAndDo() {
                System.out.println("监听并且执行");
            }
        });

        listenerTest.monitored();
    }
}
