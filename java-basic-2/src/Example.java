
public class Example {
    // static修飾子を持つメソッド
    public static void staticMethod() {
        System.out.println("This is a static method.");
    }

    public void method(){
        System.out.println("println");
    }
    public static void main(String[] args) {
        Example example = new Example();
        staticMethod();
        example.method();
    }
}

