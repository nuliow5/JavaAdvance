package eu.codeacademy.task;

public class Main {
    public static void main(String[] args) {
        InnerClass2 innerClass2 = new InnerClass2("Vardenis", "123", 321);
        innerClass2.setSk(456);
        System.out.println(innerClass2);

        System.out.println("-----------------");

        var internal = innerClass2.new Internal(111);
        internal.print();
        internal.setSk(333);
        internal.print();
        System.out.println(internal);
    }
}
