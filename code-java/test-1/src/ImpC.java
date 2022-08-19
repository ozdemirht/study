
interface BaseI { void method(); }
class BaseC {
    public void method() { System.out.println("Hello"); }
}
public class ImpC extends BaseC implements BaseI {
    public static void main(String[] args){
        (new ImpC()).method();

    }
}
