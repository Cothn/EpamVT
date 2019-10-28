import Interface.impl.console.GlobalInterfaceImpl;

public class Application {

    public static void main(String[] args) {

        GlobalInterfaceImpl globalInterfaceImpl = new GlobalInterfaceImpl();
        globalInterfaceImpl.Show();
        System.out.println("End");
    }
}
